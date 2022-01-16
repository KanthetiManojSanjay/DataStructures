package backtracking;

public class SolveNQueeen {

	private static void printBoard(int n, int board[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean solveNQueen(int n, int board[][], int i) {

		// rec case
		if (i == n) {
			printBoard(n, board);
			return true;
		}
		// rec case
		for (int j = 0; j < n; j++) {
			if (canPlace(board, n, i, j)) {
				board[i][j] = 1;
				boolean success = solveNQueen(n, board, i + 1);
				if (success) {
					return true;
				}
				// back tracking step
				board[i][j] = 0;
			}
		}

		return false;
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
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int n = 4;
		boolean flag = solveNQueen(n, board, 0);

	}

}
