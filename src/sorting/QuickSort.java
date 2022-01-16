package sorting;


/* 
 * Divide & Conquer Algorithm
 * 
 * Avg case TC is O(NLogN)
  Worst case TC is O(N^2)
*/
public class QuickSort {
	
	private static void quick_sort(int[] arr, int s, int e) {
		
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 0, 7, 6, 4 };
		int s = 0;
		int e = arr.length - 1;
		quick_sort(arr, s, e);

		for (int i = s; i <= e; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
