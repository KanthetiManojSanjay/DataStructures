package dynamicprogramming;

import java.util.Arrays;

/**
 * @author kansanja on 07/12/24.
 */

/**
 * DP(Dynamic Programming) - To consider a problem for DP it should have
 * 1) Optimal substructure - we should be able to break the problem to subproblem & solve those subProblmes to arrive at the complete result of main problem
 * 2) Overlapping subproblem - The subproblems should be repeated in other subproblems too
 * <p>
 * Can be solved in 2 ways i.e.
 * Top Down - Recursion + Memoization Approach
 * Bottom Up - Iterative Approach
 */
public class CoinChange {

    public static int minNumberOfCoinsForChange(int target, int[] denominations) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : denominations) { // Iterate over all denominations
                /** we can use denominations only if the current-denomination index >=0
                 * and wont consider if the difference is large as we dont have such denomination/coin
                 **/
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Consider minimum of so far or by considering other then +1
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }


    public static void main(String[] args) {
        int[] denominations = {1, 5, 7, 10};
        int target = 13;
        System.out.printf("Minimum no of coins required to make %d is : %d%n", target, minNumberOfCoinsForChange(target, denominations));
    }
}
