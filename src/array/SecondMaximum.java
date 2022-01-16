package array;

public class SecondMaximum {

	public static int secondMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secMax = max;
				max = arr[i];
			} else if (arr[i] > secMax && arr[i] != max) {
				secMax = arr[i];
			}
		}

		return secMax;
	}

	public static void main(String[] args) {
		int[] arr = { 13, 34, 2, 34, 33, 1 };
		int secMax = secondMax(arr);
		System.out.println("Second max value in the array is : " + secMax);
	}

}
