package array;

/**
 * @author kansanja on 24/03/24.
 */
public class PrintSubArrays {
    static void printSubArrays(int arr[], int n) {
        // for N elements in array we get appx N^2 subArrays
        // TimeComplexity - O(N^3)
        int largestSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int subArraySum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ",");
                }
                System.out.println();
            }
        }
    }


    // BruteForce Approach with timeComplexity of O(N^3)
    static int largestSubArraySum(int arr[], int n) {
        int largestSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int subArraySum = 0;
                for (int k = i; k <= j; k++) {
                    subArraySum += arr[k];
                }
                largestSum = subArraySum > largestSum ? subArraySum : largestSum;
            }
        }
        return largestSum;
    }


    // PrefixSum Approach with timeComplexity of O(N^2) with extra space
    static int largestSubArraySumUsingPrefixSum(int arr[], int n) {

        //prefix sum
        int prefix[] = new int[n];
        prefix[0] = 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int largestSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int subArraySum = i > 0 ? prefix[j] - prefix[i - 1] : prefix[j];
                largestSum = subArraySum > largestSum ? subArraySum : largestSum;
            }
        }
        return largestSum;
    }


    // Kadane's Algorithm with timeComplexity of O(N) & no extra space
    static int largestSubArraySumUsingKadanesAlgorithm(int arr[], int n) {

        int cs = 0;
        int largestSum = 0;
        for (int i = 0; i < n; i++) {
            cs = cs + arr[i];
            if (cs < 0) {
                cs = 0;
            }
            largestSum = cs > largestSum ? cs : largestSum;
        }
        return largestSum;
    }


    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60};
        int n = arr.length;
//        printSubArrays(arr, n);
        int arr1[] = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
//        System.out.println(largestSubArraySum(arr1, n));
//        System.out.println(largestSubArraySumUsingPrefixSum(arr1, n));
        System.out.println(largestSubArraySumUsingKadanesAlgorithm(arr1, n));
    }
}
