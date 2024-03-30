package recursion;

public class Factorial {

    //TimeComplexity - O(N) & Space complexity - O(N) due to call stack
    public static int fact(int n) {

        // base case
        if (n == 0) {
            return 1;
        }

        // rec case
        int ans = n * fact(n - 1);
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(fact(5));

    }

}
