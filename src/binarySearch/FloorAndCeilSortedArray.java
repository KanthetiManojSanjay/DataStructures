package binarySearch;

/**
 * @author kansanja on 17/04/24.
 */
public class FloorAndCeilSortedArray {


    private static int findFloorBinarySearch(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;
        int floor = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                // a[mid] is the floor
                return arr[mid];
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                // a[mid] is the smallest element found so far that is smaller than x. So it is a candidate for the floor of x
                floor = arr[mid];
                start = mid + 1;
            }
        }
        return floor;
    }

    private static int findCeilBinarySearch(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;
        int ceil = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                // a[mid] is the ceil
                return arr[mid];
            } else if (key < arr[mid]) {
                // a[mid] is the smallest element found so far that is greater than x. So it is a candidate for the ceiling of x
                ceil = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 9, 15, 15, 18, 21};
        int target = 5;
        int floor = findFloorBinarySearch(a, target);
        int ceil = findCeilBinarySearch(a, target);
        System.out.printf("Floor of element %d is: %d%n", target, floor);
        System.out.printf("Ceil of element %d is: %d%n", target, ceil);

        // To find minimum difference element we need to compare target with both floor & ceil and return whichever gives smallest difference
        System.out.printf("MinimumDifferenceElementWith(%d) = %d%n", target, (target - floor) < (ceil - target) ? floor : ceil);


    }
}
