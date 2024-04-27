package backtracking;


public class NQueenAll {

    private static void printBoard(int n, int board[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // Time complexity O(N^N) or O(N!)- tighter bound
    public static int solveNQueen(int n, int board[][], int i) {

        // base case
        if (i == n) {
            printBoard(n, board);
            return 1;
        }
        // rec case
        //try to place queen at every row
        int ways = 0;
        for (int j = 0; j < n; j++) {
            // check if the current i,j is safe or not
            if (canPlace(board, n, i, j)) {
                board[i][j] = 1;
                ways = ways + solveNQueen(n, board, i + 1);

                // back tracking step
                board[i][j] = 0;
            }
        }

        return ways;
    }

    private static boolean canPlace(int[][] board, int n, int x, int y) {

        // column check
        for (int k = 0; k < x; k++) {
            if (board[k][y] == 1) {
                return false;
            }
        }

        // Left diagonal check
        int i = x;
        int j = y;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;

            }
            i--;
            j--;
        }

        // Right diagonal check
        i = x;
        j = y;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return false;

            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
//		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
        int board[][] = new int[20][20];
        int n = 4;
        int ways = solveNQueen(n, board, 0);
        System.out.println("No of ways to place queens is : " + ways);

    }

}
