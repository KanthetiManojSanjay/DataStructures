package twopointer;

/**
 * @author kansanja on 18/12/24.
 */
public class ContainerWithMostWater {

    //BruteForce Approach
    // TimeComplexity - O(N^2) & SpaceComplexity - O(1)
    private static int maxAreaApproach1(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                res = Math.max(res, Math.min(heights[i], heights[j]) * (j - i));
            }
        }
        return res;
    }

    //Optimised Approach
    //TimeComplexity - O(N) & SpaceComplexity - O(1)
    private static int maxAreaApproach2(int[] heights) {

        int start = 0;
        int end = heights.length - 1;
        int res = 0;
        while (start < end) {
            int area = Math.min(heights[start], heights[end]) * (end - start);
            res = Math.max(res, area);

            if (heights[start] <= heights[end])
                start++;
            else
                end--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 7, 2, 5, 4, 7, 3, 6};
        System.out.printf("Maximum amount of water a container can store is %d%n", maxAreaApproach1(height));
        System.out.printf("Maximum amount of water a container can store is %d%n", maxAreaApproach2(height));
    }
}
