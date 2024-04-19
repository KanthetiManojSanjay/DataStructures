package twopointer;

/**
 * @author kansanja on 19/04/24.
 */
public class RemoveDuplicatesSortedArray {
    private static int removeDuplicates(int[] nums) {

        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[j++] = nums[i];
        }
        return j;
    }

    private static int removeDuplicatesII(int[] nums) {

        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && nums[i] == nums[i + 2]) {
                continue;
            }
            nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 5, 5, 7};
        int newLength = removeDuplicates(nums);
        System.out.println("Length of array after removing duplicates = " + newLength);

        System.out.print("Array = ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();


        int[] nums2 = new int[]{1, 1, 1, 3, 5, 5, 7};
        int newLength2 = removeDuplicatesII(nums2);
        System.out.println("Length of array after removing duplicates = " + newLength2);

        System.out.print("Array = ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}
