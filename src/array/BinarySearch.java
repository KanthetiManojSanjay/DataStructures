package array;

import java.util.Scanner;

/**
 * @author kansanja on 24/03/24.
 */
public class BinarySearch {
    private static int binarySearch(int[] arr, int n, int key) {

        // TimeComplexity is O(LogN) as in each iteration we are reducing the search size of array to half(i.e. N/2)
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Array should be sorted/montonic i.e. non-decreasing or non-increasing
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 89};
        int n = arr.length;
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int index = binarySearch(arr, n, key);
        if (index != -1) {
            System.out.println("Key " + key + " is present at index " + index);
        } else {
            System.out.println(key + " is not found!");
        }
    }
}
