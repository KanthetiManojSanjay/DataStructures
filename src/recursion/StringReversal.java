package recursion;

public class StringReversal {

	public static void revString(String name, int n) {

		// base case
		if (n == 0) {
			return;
		}

		String[] words = name.split(" ");
		System.out.print(words[n - 1] + " ");
		revString(name, n - 1);

	}

	public static void main(String[] args) {
		String name = "I wish to wash Wristwatch";
		String[] words = name.split(" ");
		revString(name, words.length);

	}

}
