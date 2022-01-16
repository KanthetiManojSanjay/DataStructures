package recursion;

public class SortedArray {

	public static boolean isSorted(int a[], int i, int n) {

		// base case
		if (i == n - 1) {
			return true;
		}

		// rec case
		if (a[i] < a[i + 1] && isSorted(a, i + 1, n)) {
			return true;
		}

		return false;
	}

	/* Alternative approach
	 * 
	 * public static boolean isSorted(int a[], int n) {

		// base case
		if (n == 0 || n == 1) {
			return true;
		}

		// rec case
		if (a[0] < a[1] && isSorted(a + 1, n - 1)) {
			return true;
		}

		return false;
	}*/

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int n = a.length;
		System.out.println(isSorted(a, 0, n));

	}

}
