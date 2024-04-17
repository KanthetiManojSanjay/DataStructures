package binarySearch;

public class frequencyCount {

    private static int lowerBound(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                // Found target, update lowerBound i.e. ans and move to the left to find a smaller position by setting end=mid-1
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
                // Found target, update upperBound i.e. ans and move to the right to find a higher position by setting start=mid+1
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 10};
        int key = 3;
        int lb = lowerBound(arr, key);
        int ub = upperBound(arr, key);
        System.out.println("Lower bound is :" + lb);
        System.out.println("Upper bound is :" + ub);
        if (lb != -1 && ub != -1) {
            System.out.printf("Frequency Count(%d) = %d%n", key, (ub - lb) + 1);

        } else {
            System.out.printf("Frequency Count(%d) = 0%n", key);
        }
    }


}
