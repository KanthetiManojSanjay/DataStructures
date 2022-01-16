package slidingwindow;

public class Housing {

	public static void housing(int[] plots, int target) {

		int i = 0;
		int j = 0;
		int cs = 0;
		int size = plots.length;

		while (j < size) {

			// expand to right
			cs += plots[j];
			j++;

			// contract from left
			while (cs > target && i < j) {
				cs -= plots[i];
				i++;
			}

			// when condition is met
			if (cs == target) {
				System.out.println(i + " ," + (j - 1));
			}

		}
	}

	public static void main(String[] arr) {
		int[] plots = { 1, 3, 2, 1, 4, 1, 3, 2, 1, 1 };
		int target = 8;

		housing(plots, target);

	}

}
