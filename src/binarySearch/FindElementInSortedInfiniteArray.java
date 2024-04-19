package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class FindElementInSortedInfiniteArray {
    private static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = 1;

        // First try to find the lower and upper bounds before applying binary search
        while (target > arr[end]) {
            start = end;
            end = end * 2; // Grow exponentially by doubling it
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 7, 9, 10, 12, 15, 16, 18, 20, 24, 28, 32, 35};
        int target = 16;
        System.out.printf("BinarySearch(%d) = %d%n", target, binarySearch(arr, target));

    }
}
