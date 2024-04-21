package recursion;

/**
 * @author kansanja on 20/04/24.
 */
public class PhoneKeyPad {

    static String[] keyPad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    private static void printKeyPad(String input, String output, int i) {

        //base case
        if (i == input.length()) {
            System.out.println(output);
            return;
        }


        //rec case
        int current_digit = input.charAt(i) - '0';
        if (current_digit == 0 || current_digit == 1) {
            printKeyPad(input, output, i + 1);
        }

        for (int j = 0; j < keyPad[current_digit].length(); j++) {
            printKeyPad(input, output + keyPad[current_digit].charAt(j), i + 1);
        }

    }

    public static void main(String[] args) {
        String input = "23";
        String output = "";
        printKeyPad(input, output, 0);
    }
}
