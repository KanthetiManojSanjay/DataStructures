package slidingwindow;

/**
 * @author kansanja on 18/12/24.
 */
public class BestTimeToBuyAndSellStocks {
    private static int maxProfit(int[] prices) {

        int max_profit = 0;
        int win_start = 0;
        for (int win_end = 0; win_end < prices.length; win_end++) {

            while (prices[win_end] - prices[win_start] < 0)
                win_start++;

            if (prices[win_end] - prices[win_start] > max_profit)
                max_profit = prices[win_end] - prices[win_start];

        }
        return max_profit;

    }

    public static void main(String[] args) {
        int[] prices = {10, 1, 5, 6, 7, 1};
        System.out.printf("MaxProfit obtained is %d%n", maxProfit(prices));
    }
}
