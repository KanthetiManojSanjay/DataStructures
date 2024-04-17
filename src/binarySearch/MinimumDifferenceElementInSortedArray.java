package binarySearch;

/**
 * @author kansanja on 17/04/24.
 */
public class MinimumDifferenceElementInSortedArray {

    private static int binarySearchMinDifference(int[] arr, int target) {

        int n = arr.length;

        if (target < arr[0]) {
            return arr[0];
        } else if (target > arr[n - 1]) {
            return arr[n - 1];
        }

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == arr[mid]) {
                return arr[mid];
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        /*
           At the end of the while loop,
           a[start] is the ceiling of target (Smallest number greater than target), and
           a[end] is the floor of target (Largest number smaller than target).

           Return the element whose difference with target is smaller
         */
        return (arr[start] - target) < (target - arr[end]) ? arr[start] : arr[end];

    }


    public static void main(String[] args) {
        int a[] = {2, 5, 10, 12, 15};
        int target = 6;
        System.out.printf("MinimumDifferenceElementWith(%d) = %d%n", target, binarySearchMinDifference(a, target));
    }
}
