package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumber {

	public static int[] findFirstNegativeNumberInSubarrayOfSizeK(int[] arr, int k) {

		int[] firstNegativeNumbers = new int[arr.length - k + 1];
		int win_start = 0;
		int idx = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int win_end = 0; win_end < arr.length; win_end++) {
			if (arr[win_end] < 0) {
				queue.add(arr[win_end]);
			}

			if (win_end - win_start + 1 == k) {
				if (queue.isEmpty()) {
					firstNegativeNumbers[idx++] = 0;
				} else {
					int negNo = queue.peek();
					firstNegativeNumbers[idx++] = negNo;

					if (negNo == arr[win_start]) {
						queue.remove();
					}
				}
				win_start++;
			}
		}
		return firstNegativeNumbers;
	}

	public static void main(String[] args) {
		int[] arr = { 10, -1, -5, 7, -15, 20, 18, 24 };
		int k = 3;
		int[] negArray = findFirstNegativeNumberInSubarrayOfSizeK(arr, k);
		for (int i = 0; i < negArray.length; i++) {
			System.out.print(negArray[i] + " ");
		}
	}

}
