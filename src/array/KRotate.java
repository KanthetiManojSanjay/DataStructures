package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kansanja on 26/03/24.
 */
public class KRotate {

    static Integer[] krotate(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        List<Integer> resList = new ArrayList<>();
        for (int i = n - k; i <= n - 1; i++) {
            resList.add(arr[i]);
        }

        for (int i = 0; i < n - k; i++) {
            resList.add(arr[i]);
        }

        Integer res[] = resList.toArray(new Integer[0]);
        return res;
    }

    // Additional array is not required
    static int[] krotateInplace(int arr[], int k) {
        int n = arr.length;
        reverseArray(arr, 0, n - k - 1);
        reverseArray(arr, n - k, n - 1);
        reverseArray(arr, 0, n - 1);
        return arr;
    }


    private static void reverseArray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9};
        int k = 2;
        Integer[] krotate = krotate(arr, k);
     /*   for (Integer i : krotate) {
            System.out.print(i + ",");
        }*/

        int[] inplace = krotateInplace(arr, k);
        for (int i = 0; i < inplace.length; i++) {
            System.out.print(inplace[i] + ",");
        }
    }
}
