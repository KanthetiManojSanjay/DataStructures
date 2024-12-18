package binarySearch;

/**
 * @author kansanja on 18/12/24.
 */
public class FirstLastPositionOfElement {

    private static int binarySearchFirstPosition(int[] arr, int target) {
        int firstPosition = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                firstPosition = mid;
                end = mid - 1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return firstPosition;
    }

    private static int binarySearchLastPosition(int[] arr, int target) {
        int lastPosition = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                lastPosition = mid;
                start = mid + 1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return lastPosition;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 10, 10, 15, 20};
        int target = 10;
        int firstPosition = binarySearchFirstPosition(arr, target);
        int lastPosition = binarySearchLastPosition(arr, target);
        System.out.printf("First Position is at %d & Last Position is at %d for target %d%n", firstPosition, lastPosition, target);

    }
}
