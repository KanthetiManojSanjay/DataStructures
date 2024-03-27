package array;

/**
 * @author kansanja on 24/03/24.
 */
public class PrintingPairs {
    static void printAllPairs(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            for (int j = i + 1; j < n; j++) {
                int y = arr[j];
                System.out.println(x + "," + y);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60};
        int n = arr.length;
        printAllPairs(arr, n);
    }
}
