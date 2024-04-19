package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class FindMinimumElementInRotatedSortedArray {
    private static int findMinimumElement(int[] nums) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        if (nums[0] < nums[end]) {
            return nums[0];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            // If the middle element is smaller than its previous element, then it is the minimum element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // If the middle is greater than its next element, then the next element is the minimum element
            if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[start] <= nums[mid]) { // left array is sorted. So the pivot is on the right side
                start = mid + 1;
            } else { //right array is sorted. So the pivot is on the left side
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 9, 1, 3};
        System.out.printf("Minimum Element = %d%n", findMinimumElement(nums));
    }
}
