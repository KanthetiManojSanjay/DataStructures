package slidingwindow;

/**
 * @author kansanja on 12/04/24.
 */
public class MinimumSizeSubArraySum {

    // Bruteforce approach - O(n*2) time complexity
    // //Find the Smallest subarray with Sum equal or greater than K
    private static int findLengthOfSmallestSubarray_BruteForce(int[] arr, int k) {

        int n = arr.length;
        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentSubarraySum = 0;
            for (int j = i; j < n; j++) {
                currentSubarraySum += arr[j];
                if (currentSubarraySum >= k) {
                    lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, j - i + 1);
                    break;
                }
            }

        }
        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }

    private static int findLengthOfSmallestSubarray_SlidingWindow(int[] arr, int k) {

        int win_start = 0;
        int n = arr.length;
        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        int win_sum = 0;
        for (int win_end = 0; win_end < n; win_end++) {
            win_sum += arr[win_end]; // Add the next element to the window

            while (win_sum >= k) { // shrink the window as small as possible until the 'windowSum' is smaller than 'K'
                lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, win_end - win_start + 1);
                win_sum -= arr[win_start]; // Discard the element at 'windowStart' since it is going out of the window
                win_start++; // shrink the window
            }
        }
        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }


    // Variation 2- Find the Smallest subarray with Sum exactly equal to K

    private static int findLengthOfSmallestSubarraySumExactlyK_BruteForce(int[] arr, int k) {

        int n = arr.length;
        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentSubarraySum = 0;
            for (int j = i; j < n; j++) {
                currentSubarraySum += arr[j];
                if (currentSubarraySum == k) {
                    lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, j - i + 1);
                    break;
                } else if (currentSubarraySum > k) {
                    // No need to add further elements. Since the array only has positive integers,
                    // the sum will keep increasing.
                    break;
                }
            }

        }
        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }

    private static int findLengthOfSmallestSubarraySumExactlyK_SlidingWindow(int[] arr, int k) {

        int win_start = 0;
        int n = arr.length;
        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        int win_sum = 0;
        for (int win_end = 0; win_end < n; win_end++) {
            win_sum += arr[win_end]; // Add the next element to the window

            while (win_sum > k) { // shrink the window as small as possible until the 'windowSum' is smaller than 'K'
                win_sum -= arr[win_start]; // Discard the element at 'windowStart' since it is going out of the window
                win_start++; // shrink the window
            }

            if (win_sum == k) {
                lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, win_end - win_start + 1);
            }
        }
        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }


    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 1, 6};
        int k = 9;
        System.out.println(findLengthOfSmallestSubarray_BruteForce(arr, k));
        System.out.println(findLengthOfSmallestSubarray_SlidingWindow(arr, k));

        int arr2[] = {3, 4, 1, 1, 6};
        int k2 = 8;
        System.out.printf("Length of the Smallest subarray with sum equal to %d using bruteforce approach is = %d%n", k2, findLengthOfSmallestSubarraySumExactlyK_BruteForce(arr2, k2));
        System.out.printf("Length of the Smallest subarray with sum equal to %d using siding window is = %d%n", k2, findLengthOfSmallestSubarraySumExactlyK_SlidingWindow(arr2, k2));
    }
}
