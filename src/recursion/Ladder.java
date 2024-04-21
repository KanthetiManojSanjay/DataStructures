package recursion;

/**
 * @author kansanja on 20/04/24.
 */
public class Ladder {
    private static int countWays(int n) {

        // base case
        if (n < 0)
            return 0;

        if (n == 0)
            return 1;

        //rec case
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }


    public static void main(String[] args) {
        System.out.println(countWays(3));
    }
}
