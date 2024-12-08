package dynamicprogramming;

import java.util.Arrays;

/**
 * @author kansanja on 07/12/24.
 */
// LIS (Longest Increasing Subsequence)
public class LongestIncreasingSubsequence {

    public static int lis(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int largestLength = 1;
        for (int i = 1; i < n; i++) { // Iterate remaining elements starting from index 1
            for (int j = 0; j < i; j++) { // iterate over previous element of i
                if (arr[i] > arr[j]) { // if previous element is less than current element at i
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Consider max value by considering either the value at current i.e. 1 (or) by combing previous with current hence previous +1
                    largestLength = Math.max(largestLength, dp[i]); // update lis
                }
            }

        }
        return largestLength;
    }

    public static void main(String[] args) {
        int[] arr = {50, 4, 10, 8, 30, 100};
        System.out.println(lis(arr)); // largest increasing subsequence in array is due to 4,8,30,100
    }
}
