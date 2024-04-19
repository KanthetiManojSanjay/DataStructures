package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kansanja on 19/04/24.
 */
public class TripletsWithZeroSum {
    private static List<List<Integer>> findTripletsWithZeroSum(int[] arr) {

        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // Fix one number a[i] and find pairs with sum -a[i] starting from index i+1
            addPairsWithTargetSum(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void addPairsWithTargetSum(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {

        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;

                // Skip duplicates
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }

                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {-5, 3, 2, -3, 1};
        List<List<Integer>> tripletsWithZeroSum = findTripletsWithZeroSum(arr);
        System.out.println(tripletsWithZeroSum);
    }
}
