package recursion;

/**
 * @author kansanja on 21/04/24.
 */
public class NumberSpell {

    static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    static String result;

    private static void printSpell(int num) {

        if (num == 0) {
            return;
        }

        int last_digit = num % 10;
        printSpell(num / 10);
        System.out.println(words[last_digit]);
    }


    public static void main(String[] args) {
        int n = 2021;
        printSpell(n);
    }
}
