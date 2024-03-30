package sorting;

// Time complexity - O(N+Range)
public class CountingSort {
    public static void counting_sort(int[] arr, int n) {

        int largest = -1;
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int[] freq = new int[largest + 1];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // put back the elements from freq to original array
        int j = 0;
        for (int i = 0; i <= largest; i++) {
            while (freq[i] > 0) {
                arr[j] = i;
                freq[i]--;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5, 12, 6, 1, 3};
        int n = arr.length;
        counting_sort(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
