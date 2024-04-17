package binarySearch;

public class squareRoot {

    // Binary search to find the integer value
    public static float root(int N, int P) {
        int s = 0;
        int e = N;
        float ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid * mid == N) {
                return mid;
            } else if (mid * mid < N) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        // Linear search to find the decimal value upto P places
        float inc = 0.1f;
        for (int place = 1; place <= P; place++) {
            while (ans * ans <= N) {
                ans += inc;
            }
            // take one step back
            ans -= inc;
            // decimal point increment by dividing by 10
            inc = inc / 10.0f;
            System.out.println(inc);
        }

        return ans;

    }

    public static void main(String[] args) {
        int N = 10;
        int P = 3;
        float res = root(N, P);
        System.out.println("Square root is: " + res);
    }
}
