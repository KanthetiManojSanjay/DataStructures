package sorting;

//Time complexity - O(N^2)
public class BubbleSort {

	public static void bubble_sort(int[] arr, int n) {

		for (int times = 1; times <= n - 1; times++) {
			for (int j = 0; j <= n - times - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { -2, 3, 4, -1, 5, -12, 6, 1, 3 };
		int n = arr.length;
		bubble_sort(arr, n);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
