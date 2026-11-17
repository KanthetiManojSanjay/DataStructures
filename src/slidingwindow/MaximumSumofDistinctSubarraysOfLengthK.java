package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumofDistinctSubarraysOfLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        int win_start = 0;
        long max_sum = 0;
        long curr_sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int win_end = 0; win_end < nums.length; win_end++) {
            while (set.contains(nums[win_end])) {
                set.remove(nums[win_start]);
                curr_sum -= nums[win_start];
                win_start++;
            }

            curr_sum += nums[win_end];
            set.add(nums[win_end]);
            if (win_end - win_start + 1 == k) {
                max_sum = Math.max(curr_sum, max_sum);
                set.remove(nums[win_start]);
                curr_sum -= nums[win_start];
                win_start++;
            }
        }
        return max_sum;
    }


    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 2, 9, 9, 9}, k = 3;
        long result = maximumSubarraySum(arr, k);
        System.out.println(result);
    }

}
