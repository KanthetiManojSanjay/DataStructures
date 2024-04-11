package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {

    // Bruteforce approach - O(n*k) time complexity
    public static int[] findFirstNegativeNumberInSubarrayOfSizeK_BruteForce(int[] arr, int k) {

        int n = arr.length;
        int[] firstNegativeNumbers = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int firstNegativeNum = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    firstNegativeNum = arr[j];
                    break;
                }
            }
            firstNegativeNumbers[i] = firstNegativeNum;
        }
        return firstNegativeNumbers;
    }

    // sliding window approach
    public static int[] findFirstNegativeNumberInSubarrayOfSizeK(int[] arr, int k) {

        int[] firstNegativeNumbers = new int[arr.length - k + 1];
        int win_start = 0;
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int win_end = 0; win_end < arr.length; win_end++) {
            if (arr[win_end] < 0) {
                queue.add(arr[win_end]);
            }

            if (win_end - win_start + 1 == k) { // Calculate result and Slide the window
                if (queue.isEmpty()) {
                    firstNegativeNumbers[idx++] = 0;
                } else {
                    int num = queue.peek();
                    firstNegativeNumbers[idx++] = num;

                    // Remove a[windowStart] from the queue since we need to slide the window now.
                    // But only if it was added to the queue previously
                    if (num == arr[win_start]) {
                        queue.remove();
                    }
                }
                win_start++; // Slide the window ahead
            }
        }
        return firstNegativeNumbers;
    }

    public static void main(String[] args) {
        int[] arr = {10, -1, -5, 7, -15, 20, 18, 24};
        int k = 3;
        int[] negArray_BruteForce = findFirstNegativeNumberInSubarrayOfSizeK_BruteForce(arr, k);
        for (int i = 0; i < negArray_BruteForce.length; i++) {
            System.out.print(negArray_BruteForce[i] + " ");
        }
        System.out.println();
        int[] negArray = findFirstNegativeNumberInSubarrayOfSizeK(arr, k);
        for (int i = 0; i < negArray.length; i++) {
            System.out.print(negArray[i] + " ");
        }
    }

}
