package backtracking;

public class FindSubsets {

	public static void findSubSets(char[] input, char[] output, int i, int j) {

		if (input[i] == '\0') {
			output[i] = '\0';
			if (input[0] == '\0') {
				System.out.print("NULL");
			}
			System.out.print(output);
		}

		output[j] = input[i];
		findSubSets(input, output, i + 1, j + 1);

		findSubSets(input, output, i + 1, j);
	}

	public static void main(String[] args) {
		char in[] = { 'a', 'b', 'c' };
		char out[] = {};
		findSubSets(in, out, 0, 0);
	}

}
