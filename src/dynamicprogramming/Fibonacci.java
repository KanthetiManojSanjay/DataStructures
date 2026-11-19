package dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {

    // Top down approach - Memoization with O(n) time complexity and O(n) space complexity
    public static int fibonacci(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }

    // Bottom up approach - Iterative with O(n) time complexity and O(n) space complexity
    public static int fibonacci_bottom_up(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        System.out.println(fibonacci(n, dp));
    }
}
