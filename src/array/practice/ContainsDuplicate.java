package array.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 09/04/24.
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        int length = nums.length;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int element = nums[i];
            if (numsMap.containsKey(element)) {
                numsMap.put(element, numsMap.get(element) + 1);
            } else {
                numsMap.put(element, 1);
            }
        }

        for (Map.Entry<Integer, Integer> ele : numsMap.entrySet()) {
            if (ele.getValue() > 1) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }

}
