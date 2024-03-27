package array;

/**
 * @author kansanja on 24/03/24.
 */
public class ArrayReverse {

    static void reverseArray(int arr[], int n) {
        int start = 0;
        int end = n - 1;
        // TimeComplexity - O(N) & SpaceComplexity - O(1)
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 45, 60, 80, 90, 100};
        int n = arr.length;
        reverseArray(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
