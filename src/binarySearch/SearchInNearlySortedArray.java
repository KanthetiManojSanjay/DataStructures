package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class SearchInNearlySortedArray {
    private static int binarySearchNearlySorted(int[] arr, int target) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (mid > 0 && target == arr[mid - 1]) {
                return mid - 1;
            } else if (mid < n - 1 && target == arr[mid + 1]) {
                return mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {10, 3, 40, 20, 50, 80, 70}, target = 3;
        System.out.printf("BinarySearchNearlySorted(%d) = %d%n", target, binarySearchNearlySorted(arr, target));
    }
}
