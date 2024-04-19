package twopointer;

import java.util.Arrays;

/**
 * @author kansanja on 19/04/24.
 */
public class SquaresOfSortedArray {

    public static int[] sortedSquares(int[] arr) {

        int n = arr.length;
        int[] squaredArr = new int[n];
        int smallestSquareIdx = 0;

        // Find the index of first non-negative element
        int firstNonNegativeElementIndex = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                firstNonNegativeElementIndex = i;
                break;
            }
        }

        // Pointer to iterate over the negative elements
        int negItr = firstNonNegativeElementIndex - 1;
        // Pointer to iterate over the non-negative elements
        int posItr = firstNonNegativeElementIndex;

        while (negItr >= 0 && posItr < n) {
            int negElementSquare = arr[negItr] * arr[negItr];
            int posElementSquare = arr[posItr] * arr[posItr];

            if (negElementSquare < posElementSquare) {
                squaredArr[smallestSquareIdx++] = negElementSquare;
                negItr--;
            } else {
                squaredArr[smallestSquareIdx++] = posElementSquare;
                posItr++;
            }
        }
        while (negItr >= 0) {
            squaredArr[smallestSquareIdx++] = arr[negItr] * arr[negItr];
            negItr--;
        }

        while (posItr < n) {
            squaredArr[smallestSquareIdx++] = arr[posItr] * arr[posItr];
            posItr++;
        }
        return squaredArr;
    }

    public static int[] sortedSquaresSimplified(int[] arr) {
        int n = arr.length;
        int squaredArr[] = new int[n];
        int highestSquareIdx = n - 1;

        int left = 0, right = n - 1;

        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squaredArr[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squaredArr[highestSquareIdx--] = rightSquare;
                right--;
            }

        }
        return squaredArr;
    }

    public static void main(String[] args) {
        int arr[] = {-5, -2, -1, 0, 4, 6};
        System.out.println(Arrays.toString(sortedSquares(arr)));
        System.out.println(Arrays.toString(sortedSquaresSimplified(arr)));
    }
}
