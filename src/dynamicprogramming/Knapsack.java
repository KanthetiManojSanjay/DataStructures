package dynamicprogramming;

/**
 * @author kansanja on 07/12/24.
 */
public class Knapsack {

    // Top-Down Approach
    private static int knapsackTD(int[] wts, int[] prices, int N, int W) {
        // base case
        if (N == 0 || W == 0) {
            return 0;
        }

        //rec case
        int inc = 0;
        int exc = 0;
        if (wts[N - 1] <= W) {
            inc = prices[N - 1] + knapsackTD(wts, prices, N - 1, W - wts[N - 1]);
        }
        exc = knapsackTD(wts, prices, N - 1, W);
        return Math.max(inc, exc);
    }

/*    // Bottom-Up Approach
    private static int knapsackBU(int[] wts, int[] prices, int N, int W) {

    }*/

    public static void main(String[] args) {
        int[] wts = {2, 7, 3, 4};
        int[] prices = {5, 20, 20, 10};
        int N = 4;
        int targetWeight = 11;
        System.out.printf("Max price to achieve %d is %d%n", targetWeight, knapsackTD(wts, prices, N, targetWeight));
    }


}
