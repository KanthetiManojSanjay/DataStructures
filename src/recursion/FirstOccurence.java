package recursion;

public class FirstOccurence {

    public static int firstOcc(int[] arr, int srtidx, int n, int key) {
        // base case
        if (srtidx == n - 1) {
            return -1;
        }

        // rec case
        if (arr[srtidx] == key) {
            return 0;
        }
        srtidx++;
        int subIndex = firstOcc(arr, srtidx, n, key);
        if (subIndex != -1) {
            return subIndex + 1;
        }
        return -1;
    }

    public static int lastOcc(int[] arr, int srtidx, int n, int key) {
        // base case
        if (srtidx == n - 1) {
            return -1;
        }

        srtidx++;
        // rec case
        int subIndex = lastOcc(arr, srtidx, n, key);
        if (subIndex == -1) {
            if (arr[srtidx] == key)
                return 1;
            else
                return -1;

        } else {
            return subIndex + 1;
        }

    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 6, 5, 2, 11, 7, 21};
        int n = arr.length;
        int key = 7;
        System.out.println(firstOcc(arr, 0, n, key));
        System.out.println(lastOcc(arr, 0, n, key));

    }

}
