package binarySearch;

import java.util.Scanner;

/**
 * @author kansanja on 16/04/24.
 */
public class OrderAgnosticBinarySearch {

    // Iterative Approach
    private static int binarySearch(int[] arr, int n, int key) {

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if ((arr[start] < arr[end] && arr[mid] > key) || (arr[start] > arr[end] && arr[mid] < key)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    // Recursive Approach
    private static int binarySearch_Recursively(int[] arr, int start, int end, int key) {

        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if ((arr[start] < arr[end] && arr[mid] > key) || (arr[start] > arr[end] && arr[mid] < key)) {
            return binarySearch_Recursively(arr, start, mid - 1, key);
        } else {
            return binarySearch_Recursively(arr, mid + 1, end, key);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 11, 19};

        int n = arr.length;
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int index = binarySearch(arr, n, key);
        if (index != -1) {
            System.out.println("Key " + key + " is present at index " + index);
        } else {
            System.out.println(key + " is not found!");
        }

        int arr2[] = {32, 28, 17, 9, 3};
        int n2 = arr2.length;
        Scanner sc2 = new Scanner(System.in);
        int key2 = sc2.nextInt();
        int index2 = binarySearch_Recursively(arr2, 0, n2 - 1, key2);
        if (index2 != -1) {
            System.out.println("Key " + key2 + " is present at index " + index2);
        } else {
            System.out.println(key2 + " is not found!");
        }
    }
}
