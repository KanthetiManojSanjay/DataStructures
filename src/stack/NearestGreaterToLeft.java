package stack;

import java.util.Stack;

public class NearestGreaterToLeft {

	public static int[] findNearestGreaterToLeft(int[] arr) {

		int[] NGL = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			NGL[i] = -1;

			while (!stack.isEmpty()) {
				int top = stack.peek();
				if (top > arr[i]) {
					NGL[i] = top;
					break;
				} else {
					stack.pop();
				}
			}
			stack.push(arr[i]);
		}
		return NGL;
	}

	public static void main(String[] args) {
		int[] arr = { 9, 4, 15, 6, 2, 10 };
		int[] array = findNearestGreaterToLeft(arr);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
