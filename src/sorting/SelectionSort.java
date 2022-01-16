package sorting;

// Repeatedly find min element from unsorted array and place it at the beginning
//Time complexity - O(N^2)
public class SelectionSort {

	public static void selection_sort(int[] arr, int n) {

		for (int pos = 0; pos <= n - 2; pos++) {
			int min_element = pos;

			for (int j = pos; j < n; j++) {
				if (arr[j] < arr[min_element]) {
					min_element = j;
				}
			}

			int temp = arr[pos];
			arr[pos] = arr[min_element];
			arr[min_element] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		int n = arr.length;
		selection_sort(arr, n);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
