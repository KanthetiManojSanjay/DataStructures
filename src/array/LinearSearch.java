package array;

import java.util.Scanner;

/**
 * @author kansanja on 24/03/24.
 */
public class LinearSearch {

    private static int linearSearch(int[] arr, int n, int key) {
        // In worth case to find key we have to iterative entire array so TimeComplexity is O(N)
        for (int i = 0; i < n; i++) {
            // check if the current element matches with key
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {10, 15, 12, 9, 6, 4, 3, 10, 8};
        int n = arr.length;
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int index = linearSearch(arr, n, key);
        if (index != -1) {
            System.out.println("Key " + key + " is present at index " + index);
        } else {
            System.out.println(key + " is not found!");
        }
    }


}
