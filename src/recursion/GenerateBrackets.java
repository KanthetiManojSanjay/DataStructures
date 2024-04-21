package recursion;

/**
 * @author kansanja on 20/04/24.
 */
public class GenerateBrackets {

    private static void generateBrackets(String output, int n, int open, int close, int i) {

        //base case
        // for n pairs we need to fill 2n positions
        if (i == 2 * n) {
            System.out.println(output);
            return;
        }

        //rec case for open
        if (open < n)
            generateBrackets(output + '(', n, open + 1, close, i + 1);

        //rec case for close
        if (close < open)
            generateBrackets(output + ')', n, open, close + 1, i + 1);
    }

    public static void main(String[] args) {
        int n = 3;
        String output = "";
        generateBrackets(output, n, 0, 0, 0);
    }
}
