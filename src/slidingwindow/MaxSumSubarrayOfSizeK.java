package slidingwindow;

public class MaxSumSubarrayOfSizeK {

	
	// Bruteforce approach - O(n*k) time complexity
	public static int maxSumSubArray(int[] arr, int size) {
		int maxSum = 0;
		int subArrSum;
		for (int i = 0; i <= arr.length - size; i++) {
			subArrSum = 0;
			for (int j = i; j < i + size; j++) {
				subArrSum += arr[j];
			}
			maxSum = Math.max(maxSum, subArrSum);
		}
		return maxSum;
	}

	// sliding window
	private static int findSumMaxSubarrayOfSizeK(int[] arr, int size) {

		int win_start = 0;
		int targetSize = size;
		int win_sum = 0;
		int max_sum = Integer.MIN_VALUE;
		for (int win_end = 0; win_end < arr.length; win_end++) {
			win_sum += arr[win_end]; // Add the next element to the sum
			if (win_end - win_start + 1 == targetSize) { // when we hit the window size then update the maxSum & slide
															// the window
				max_sum = Math.max(max_sum, win_sum);
				win_sum -= arr[win_start]; // substract the element going out of the window
				win_start++; // slide the window
			}
		}
		return max_sum;

	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 5, 1, 2 };
		int size = 3;
//		int[] arr = { 3,5,2,1,7};
//		int size = 2;
		int maxSum = findSumMaxSubarrayOfSizeK(arr, size);
		System.out.println("Max sum value by sliding window approach is :" + maxSum);

		int max_sum = maxSumSubArray(arr, size);
		System.out.println("Max sum value by bruteforce approach is :" + max_sum);

	}

}
