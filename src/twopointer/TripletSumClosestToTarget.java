package twopointer;

import java.util.Arrays;

/**
 * @author kansanja on 19/04/24.
 */
public class TripletSumClosestToTarget {
    private static int findTripletSumClosestToTarget(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            // Fix one number
            int firstNum = arr[i];

            // Use Two-sum approach to get the other two numbers
            // such that the sum of all three numbers are closest to target
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int currentSum = firstNum + arr[left] + arr[right];
                int currentDiff = targetSum - currentSum;
                if (currentDiff == 0) {
                    return currentSum;
                }
                if (Math.abs(currentDiff) < Math.abs(smallestDiff)) {
                    smallestDiff = currentDiff;
                }

                if (currentDiff > 0) {
                    // TargetSum is greater than the sum of triplets.
                    // Increment left pointer to increase the sum so that the difference moves closer to zero
                    left++;
                } else {
                    // TargetSum is smaller than the sum of triplets.
                    // Decrement right pointer to decrease the sum  so that the difference moves closer to zero
                    right--;
                }

            }
        }
        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        int arr[] = {-2, -4, 6, 3, 7}, target = 2;
        System.out.printf("Triplet sum closest to target = %d%n", findTripletSumClosestToTarget(arr, target));
    }
}


