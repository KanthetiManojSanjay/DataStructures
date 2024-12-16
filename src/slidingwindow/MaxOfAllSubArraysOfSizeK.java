package slidingwindow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kansanja on 11/04/24.
 */
public class MaxOfAllSubArraysOfSizeK {

    // Bruteforce approach - O(n*k) time complexity
    private static int[] maxofAllSubarray_BruteForce(int[] arr, int k) {

        int n = arr.length;
        int[] maxSubarrayNum = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int maxNumber = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (arr[j] > maxNumber) {
                    maxNumber = arr[j];
                }
            }
            maxSubarrayNum[i] = maxNumber;
        }
        return maxSubarrayNum;
    }

    private static int[] maxofAllSubarray_SlidingWindow(int[] arr, int k) {

        int win_start = 0;
        int[] maxSubarrayNum = new int[arr.length - k + 1];
        int idx = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int win_end = 0; win_end < arr.length; win_end++) {
            queue.add(arr[win_end]);

            // We've hit the window size. Find the maximum in the current window and Slide the window ahead
            if (win_end - win_start + 1 == k) {
                Integer maxNumber = queue.peek();
                maxSubarrayNum[idx++] = maxNumber;

                // Discard a[windowStart] since we are sliding the window now. So it is going out of the window.
                if (maxNumber == arr[win_start]) {
                    queue.remove();
                }
                win_start++; // slide the window

            }
        }
        return maxSubarrayNum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3;
        int[] resArray1 = maxofAllSubarray_BruteForce(arr, k);
        for (int i : resArray1) {
            System.out.print(i + ",");
        }

        System.out.println();
        int[] resArray = maxofAllSubarray_SlidingWindow(arr, k);
        for (int i : resArray) {
            System.out.print(i + ",");
        }

    }
}
