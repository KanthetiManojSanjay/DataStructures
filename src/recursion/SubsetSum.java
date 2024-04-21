package recursion;

/**
 * @author kansanja on 20/04/24.
 */
public class SubsetSum {

    private static int countSubSets(int[] arr, int n, int i, int targetSum) {

        //base case
        if (i == n) {
            if (targetSum == 0)
                return 1;
            else return 0;
        }

        //recursive case
        int currentDigIncluded = countSubSets(arr, n, i + 1, targetSum - arr[i]);
        int currentDigExcluded = countSubSets(arr, n, i + 1, targetSum);
        return currentDigIncluded + currentDigExcluded;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int targetSum = 10;
        System.out.printf("No of subsets for targetSum %d is: %d%n", targetSum, countSubSets(arr, arr.length, 0, targetSum));

    }

}
