package twopointer;

import java.util.Arrays;

/**
 * @author kansanja on 16/04/24.
 */
public class MinPair {
    private static int[] findSmallestDifferencePair(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int smallestDiffPair[] = new int[2];
        double smallestDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            double currentDiff = Math.abs(arr1[i] - arr2[j]);
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestDiffPair[0] = arr1[i];
                smallestDiffPair[1] = arr2[j];
            }

            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return smallestDiffPair;
    }


    public static void main(String[] args) {
        int[] arr1 = {-1, 5, 10, 20, 3};
        int[] arr2 = {26, 134, 135, 15, 17};
        int[] pair = findSmallestDifferencePair(arr1, arr2);
        System.out.println(pair[0] + " " + pair[1]);
    }


}
