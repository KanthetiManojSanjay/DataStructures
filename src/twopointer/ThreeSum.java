package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kansanja on 09/04/24.
 */
public class ThreeSum {

    //Two pointer approach - O(N^2)
    public static List<Integer[]> threeSum(int[] nums, int target) {
        List<Integer[]> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == target) {
                    resultList.add(new Integer[]{nums[i], nums[start], nums[end]});
                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int target = 18;
        List<Integer[]> threeSumList = threeSum(nums, target);
        for (Integer[] pairs : threeSumList) {
            System.out.println(Arrays.toString(pairs));
        }
    }
}
