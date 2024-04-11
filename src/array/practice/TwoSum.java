package array.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 09/04/24.
 */
public class TwoSum {

    public static int[] twoSumPairIndex(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static int[] twoSumPairValue(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

     /*   int[] nums = {2, 7, 11, 15};
        int target = 9;*/

        int[] nums = {3, 2, 0};
        int target = 6;

      /*  int[] twoSumPairValue = twoSumPairValue(nums, target);
        System.out.println(twoSumPairValue[0] + "," + twoSumPairValue[1]);*/

        int[] twoSumPairIndex = twoSumPairIndex(nums, target);
        if (twoSumPairIndex.length > 0) {
            System.out.println(twoSumPairIndex[0] + "," + twoSumPairIndex[1]);
        }


    }
}
