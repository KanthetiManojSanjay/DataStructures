package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class SearchInBitonicArray {
    // Bitonic Search
    private static int search(int[] arr, int target) {
        int maxIndex = findMaxElement(arr);
        int targetIndex = binarySearch(arr, 0, maxIndex, target);
        if (targetIndex != -1) {
            return targetIndex;
        }
        return binarySearch(arr, maxIndex + 1, arr.length - 1, target);
    }

    // Order agnostic binary search
    private static int binarySearch(int[] arr, int start, int end, int target) {

        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if ((arr[start] < arr[end] && arr[mid] > target) || (arr[start] > arr[end] && arr[mid] < target)) {
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }


    // Find Max element in a Bitonic array
    private static int findMaxElement(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid; // a[mid] is greater than both its neighbours
            } else if (arr[mid] < arr[mid - 1]) {
                end = mid - 1; // a[mid] is smaller than its previous element, maximum lies in left half
            } else {
                start = mid + 1; // maximum lies in the right half
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int arr[] = {2, 4, 8, 10, 7, 6, 1}, target = 6;
        System.out.printf("BinarySearchBitonicArray(%d) = %d%n", target, search(arr, target));

    }
}
