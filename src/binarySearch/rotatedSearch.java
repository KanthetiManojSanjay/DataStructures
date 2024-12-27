package binarySearch;

public class rotatedSearch {
    private static int search(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[s] < arr[mid]) { // left array is sorted
                if (key >= arr[s] && key < arr[mid]) { // target lies between start and mid index
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }

            } else { // right array is sorted
                if (key > arr[mid] && key <= arr[e]) { // target lies between mid and end index
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 11, 13, 15, 1, 4};
        int target = 4;
        int index = search(arr, target);
        System.out.println("Index of target is: " + index);

    }


}
