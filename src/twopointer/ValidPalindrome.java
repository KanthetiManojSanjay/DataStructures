package twopointer;

/**
 * @author kansanja on 15/12/24.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNumberic(s.charAt(left))) {
                left++;

            }
            while (left < right && !isAlphaNumberic(s.charAt(right))) {
                right--;
            }

            if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private static boolean isAlphaNumberic(Character ch) {
        return (Character.isAlphabetic(ch) || Character.isDigit(ch));
    }

    public static void main(String[] args) {
        String str = "Was it a car or a cat I saw?";
        String str1 = "tab a cat";
        String str2 = "0P";
        System.out.println(isPalindrome(str2));


    }
}
