package recursion;

public class Power {

    // Time complexity -> O(N)
    public static int power(int a, int n) {
        if (n == 0) {
            return 1;
        }

        return a * power(a, n - 1);
    }

    // Time & space complexity - O(logN)
    public static int fastPower(int a, int n) {
        if (n == 0) {
            return 1;
        }

        int subPrb = fastPower(a, n / 2);
        int subPrbSq = subPrb * subPrb;
        if (n % 2 != 0) {
            return a * subPrbSq;
        }
        return subPrbSq;

    }

    public static void main(String[] args) {
        System.out.println("Power :" + power(3, 5));
        System.out.println("Power :" + fastPower(3, 5));

    }

}
