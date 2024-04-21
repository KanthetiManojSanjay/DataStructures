package backtracking;

public class FindSubsets {

    public static void findSubSets(char[] input, char[] output, int i, int j) {

        if (i == input.length) {
            output[j] = '\0';
            if (output[0] == '\0') {
                System.out.println("NULL");
            }
            System.out.println(output);
            return;
        }

        output[j] = input[i];

        findSubSets(input, output, i + 1, j + 1);

        findSubSets(input, output, i + 1, j);
    }

    public static void main(String[] args) {
        char[] in = "abc".toCharArray();
        char[] out = new char[100];
        findSubSets(in, out, 0, 0);
    }

}
