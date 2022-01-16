package sorting;

import java.util.ArrayList;
import java.util.List;

// Divide & Conquer Algorithm
public class MergeSort {

	private static void merge_sort(int[] arr, int s, int e) {
		// base case
		if (s >= e) {
			return;
		}

		// rec case
		int mid = (s + e) / 2;
		merge_sort(arr, s, mid);
		merge_sort(arr, mid + 1, e);
		merge(arr, s, e);

	}

	private static int[] merge(int[] arr, int s, int e) {

		int i = s;
		int m = (s + e) / 2;
		int j = m + 1;
		List<Integer> list = new ArrayList<>();
		while (i <= m && j <= e) {
			if (arr[i] < arr[j]) {
				list.add(arr[i]);
				i++;
			} else {
				list.add(arr[j]);
				j++;
			}
		}

		while (i <= m) {
			list.add(arr[i]);
			i++;
		}
		while (j <= e) {
			list.add(arr[j]);
			j++;
		}
		int k = 0;
		for (int idx = s; idx <= e; idx++) {
			arr[idx] = list.get(k);
			k++;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 0, 7, 6, 4 };
		int s = 0;
		int e = arr.length - 1;
		merge_sort(arr, s, e);

		for (int i = s; i <= e; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
