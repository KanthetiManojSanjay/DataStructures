package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class RotationCountRotatedSortedArray {
    private static int findRotationCount(int[] arr) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }

            if (mid < n - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if (arr[start] <= arr[mid]) {
                end = mid + 1;
            } else {
                start = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {5, 7, 9, 1, 3};
        System.out.printf("Rotation Count = %d%n", findRotationCount(arr));
    }
}
