package binarySearch;

/**
 * @author kansanja on 18/04/24.
 */
public class Sorted2DMatrixSearch {
    // TimeComplexity - O(log(m*n))
    private static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;

        int start = 0;
        int end = noOfRows * noOfCols - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = matrix[mid / noOfCols][mid % noOfCols];

            if (midValue == target) {
                return true;
            } else if (target < midValue) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9, 11},
                {13, 16, 19, 24},
                {28, 30, 38, 50}
        };
        int target = 5;

        System.out.println(searchMatrix(matrix, target));
    }
}
