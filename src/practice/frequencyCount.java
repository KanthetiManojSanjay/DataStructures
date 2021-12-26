package practice;

public class frequencyCount {
	public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 10};
        int lb = lowerBound(arr, 3);
        int ub = upperBound(arr, 3);
        int count=(ub - lb) + 1;
        System.out.println("Frequency count is :" + count);
    }

    private static int lowerBound(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) {
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

}
