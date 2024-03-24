/*
package recursion;

public class FirstOccurence {

	public static int firstOcc(int[] arr, int n, int key) {
		// base case
		if (n == 0) {
			return -1;
		}

		// rec case
		if (arr[0] == key) {
			return 0;
		}
		int subIndex = firstOcc(arr + 1, n - 1, key);
		if (subIndex != -1) {
			return subIndex + 1;
		}
		return -1;

	}

	public static int lastOcc(int[] arr, int n, int key) {
		// base case
		if (n == 0) {
			return -1;
		}

		// rec case
		int subIndex = lastOcc(arr + 1, n - 1, key);
		if (subIndex == -1) {
			if (arr[0] == key)
				return 0;
			else
				return -1;

		} else {
			return subIndex + 1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/
