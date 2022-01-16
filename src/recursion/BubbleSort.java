package recursion;

public class BubbleSort {

	public static void bubble_sort_rec(int[] arr, int n) {

		// base case
		if (n == 1) {
			return;
		}

		for (int j = 0; j < n - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		bubble_sort_rec(arr, n - 1);

	}

	public static void bubble_sort_rec2(int[] arr, int n, int j) {

		// base case
		if (n == 1) {
			return;
		}

		if (j == n - 1) {
			bubble_sort_rec2(arr, n - 1, 0);
			return;
		}
		if (arr[j] > arr[j + 1]) {
			int temp = arr[j];
			arr[j] = arr[j + 1];
			arr[j + 1] = temp;
		}

		bubble_sort_rec2(arr, n, j + 1);

	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 1, 7 };
		bubble_sort_rec(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}

		System.out.println(" ");
		int[] arr2 = { 2, 4, 6, 1, 7 };
		bubble_sort_rec2(arr2, arr2.length, 0);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + ",");
		}

	}

}
