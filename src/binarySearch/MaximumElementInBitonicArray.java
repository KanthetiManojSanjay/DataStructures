package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class MaximumElementInBitonicArray {
    /**
     * A bitonic array is an array that is first increasing and then decreasing
     * If the mid element is greater than both of its adjacent elements, then return a[mid] because it is the maximum.
     * If the mid element is greater than its next element and smaller than its previous element, then the maximum lies on the left side of mid. (Ex: {3, 23, 10, 8, 7, 6})
     * If the mid element is greater than its previous element and smaller than its next element, then the maximum lies on the right side of mid. (Ex: {2, 4, 6, 8, 10, 3, 1})
     */
    private static int findMaxElement(int[] arr) {

        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid]; // a[mid] is greater than both its neighbours
            } else if (arr[mid] < arr[mid - 1]) {
                end = mid - 1; // a[mid] is smaller than its previous element, maximum lies in left half
            } else {
                start = mid + 1; // maximum lies in the right half
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2, 4, 6, 8, 10, 3, 1};
        System.out.printf("MaxElement = %d%n", findMaxElement(a));

    }
}
