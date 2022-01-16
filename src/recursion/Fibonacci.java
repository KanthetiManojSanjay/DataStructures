package recursion;

public class Fibonacci {

	public static int fib(int n) {

		// base case
		if (n == 0 || n == 1) {
			return n;
		}

		// rec case
		int ans = fib(n - 1) + fib(n - 2);
		return ans;
	}

	public static void main(String[] args) {
		System.out.print(fib(7));

	}

}
