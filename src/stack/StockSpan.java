package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    // TimeComplexity - O(N*2) & Space Complexity - O(1)
    public static int[] stockSpanUsingBruteForce(int[] stockPrices) {

        int n = stockPrices.length;
        int span[] = new int[n];

        for (int i = 0; i < n; i++) {
            span[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (stockPrices[j] <= stockPrices[i]) {
                    span[i]++;
                } else {
                    break;
                }
            }
        }
        return span;
    }

    private static int[] stockSpanUsingStack(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] span = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }
        return span;
    }

    // TimeComplexity - O(N) & Space Complexity - O(N)
    public static int[] stockSpanUsingStackUsingNGL(int[] stockPrices) {
        int[] ngl = findNearestGreaterToLeft(stockPrices);
        System.out.println(Arrays.toString(ngl));
        int span[] = new int[ngl.length];
        for (int i = 0; i < ngl.length; i++) {
            span[i] = i - ngl[i];
        }
        return span;
    }

    private static int[] findNearestGreaterToLeft(int[] stockPrices) {

        int n = stockPrices.length;
        int[] NGL = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            NGL[i] = -1;

            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (stockPrices[top] > stockPrices[i]) {
                    NGL[i] = top;
                    break;
                }else {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return NGL;
    }


    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        int[] array1 = stockSpanUsingBruteForce(arr);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.println("");
        int[] array2 = stockSpanUsingStack(arr);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }

        System.out.println("");
        int[] array3 = stockSpanUsingStackUsingNGL(arr);
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }

    }

}
