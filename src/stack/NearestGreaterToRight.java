package stack;

import java.util.Stack;

public class NearestGreaterToRight {

	private static int[] nextGreaterElementUsingStack(int[] arr) {
		int[] NGR = new int[arr.length];

		Stack<Integer> stack = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			NGR[i] = -1;

			while (!stack.isEmpty()) {
				int top = stack.peek();
				if (top > arr[i]) {
					NGR[i] = top;
					break;
				} else {
					stack.pop();
				}
			}
			stack.push(arr[i]);

		}
		return NGR;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 4, 12, 5, 2, 10 };
		int[] array = nextGreaterElementUsingStack(arr);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
