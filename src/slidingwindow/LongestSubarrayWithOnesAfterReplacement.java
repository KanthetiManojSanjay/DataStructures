package slidingwindow;

/**
 * @author kansanja on 14/04/24.
 */
public class LongestSubarrayWithOnesAfterReplacement {
    private static int findMaxConsecutiveOnes(int[] a, int k) {

        int maxOnes = Integer.MIN_VALUE;
        int numReplacements = 0;
        int win_start = 0;
        for (int win_end = 0; win_end < a.length; win_end++) {
            // we consider fliping from 0 to 1 by incrementing the numReplacements variable count if the element is 0
            if (a[win_end] == 0) {
                numReplacements++;
            }

            /*
            If numReplacements is greater than the number of allowed replacements, then we can’t proceed,
            and we must shift our window by incrementing windowStart until numReplacements becomes equal to
            the number of allowed replacements.
             */
            // Discard the character at the window start by flipping back from 0 to 1 and reducing the the count of numReplacements
            while (numReplacements > k) {
                if (a[win_start] == 0) {
                    numReplacements--;
                }
                win_start++; // Shrink the window
            }

            maxOnes = Math.max(maxOnes, win_end - win_start + 1);
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        int result1 = findMaxConsecutiveOnes(a1, k1);
        System.out.printf("Length of longest contiguous subarray containing only 1s after replacement = %d%n", result1);


        int[] a2 = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k2 = 3;
        int result2 = findMaxConsecutiveOnes(a2, k2);
        System.out.printf("Length of longest contiguous subarray containing only 1s after replacement = %d%n", result2);

    }
}
