package array;

/**
 * @author kansanja on 26/03/24.
 */

/**
 * Given an array of integers A (sorted) and a integer Val.
 * Implement a function that takes A and Val as input parameters and returns the lower bound of Val.
 * Note : If Val is not present in array then Lower bound of a given integer means integer which is just smaller than given integer.
 * Otherwise Val itself is the answer.
 * If Val is less than smallest element of array A then return '-1' in that case.
 */
public class ArrayLowerBound {

    static int lowerBound(int arr[], int val) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= val) {
                ans = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-1, -1, 2, 3, 5};
//        int arr[] = {1, 2, 3, 5};
        int val = -2;
        System.out.println(lowerBound(arr, val));
    }
}
