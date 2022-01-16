package sorting;

//Time complexity - O(N^2)
public class InsertionSort {

	public static void insertion_sort(int[] arr, int n) {
		for (int i = 1; i <= n - 1; i++) {
			int current = arr[i];
			int prev = i - 1;

			// loop to identity right index where the current element should be inserted
			while (prev >= 0 && arr[prev] > current) {
				arr[prev + 1] = arr[prev];
				prev = prev - 1;
			}
			arr[prev + 1] = current;
		}
	}

	public static void main(String[] args) {
		int[] arr = { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		int n = arr.length;
		insertion_sort(arr, n);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
