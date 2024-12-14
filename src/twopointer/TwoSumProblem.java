package twopointer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

    // To get value
    // Time complexity - O(NLogN)
    private static int[] findTwoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] == target) {
                return new int[]{arr[left], arr[right]};
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else if (arr[left] + arr[right] > target) {
                right--;
            }
        }
        return new int[]{};
    }

    // To get index
    // Time complexity O(N)
    private static int[] findTwoSumUsingHashMap(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] array = findTwoSum(arr, target);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        int[] array1 = findTwoSumUsingHashMap(arr, target);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
    }

    int[] a1 = new int[]{-1, 5, 10, 20, 28, 3};
    //	-1, 3, 5, 10, 20, 28
    int[] a2 = new int[]{26, 134, 135, 15, 17};

//	15, 17, 26, 134, 135

}
