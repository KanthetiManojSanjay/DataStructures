package twopointer;

/**
 * @author kansanja on 18/12/24.
 */
public class ContainerWithMostWater {
    private static int maxArea(int[] heights) {

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
        System.out.printf("Maximum amount of water a container can store is %d%n", maxArea(height));
    }
}
