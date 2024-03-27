package array;

/**
 * @author kansanja on 26/03/24.
 */
public class ArrayLowerBound {

    static int lowerBound(int arr[], int val) {

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= val) {
                ans = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int arr[] = {-1, -1, 2, 3, 5};
//        int arr[] = {1, 2, 3, 5};
        int arr[] = {1, 2, 3, 5};
        int val = 2;
        System.out.println(lowerBound(arr, val));
    }
}
