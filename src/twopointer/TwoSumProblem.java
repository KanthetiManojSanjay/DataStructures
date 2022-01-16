package twopointer;

import java.util.HashMap;

public class TwoSumProblem {

	// To get value
	// Time complexity - O(N)
	private static int[] findTwoSum(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] + arr[right] == target) {
				return new int[] { arr[left], arr[right] };
			} else if (arr[left] + arr[right] < target) {
				left++;
			} else if (arr[left] + arr[right] > target) {
				right--;
			}
		}
		return new int[] {};
	}

	// To get index
	// Time complexity O(NlogN)
	private static int[] findTwoSumUsingHashMap(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}else {
				map.put(arr[i], i);
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
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

}
