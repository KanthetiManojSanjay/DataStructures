package twopointer;

/**
 * @author kansanja on 15/12/24.
 */
public class ValidPalindrome {

    // Bruteforce Approach
    // Time Complexity - O(N) & Space Complexity - O(N)
    public static boolean isPalindromeApproach1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }


    // Optimised Approach
    // Time Complexity - O(N) & Space Complexity - O(1)
    public static boolean isPalindromeApproach2(String s) {
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
        return (ch >= 'A' && ch <= 'Z' ||
                ch >= 'a' && ch <= 'z' ||
                ch >= '0' && ch <= '9');
    }

    public static void main(String[] args) {
        String str = "Was it a car or a cat I saw?";
        String str1 = "tab a cat";
        String str2 = "!00";
        System.out.println(isPalindromeApproach1(str));
        System.out.println(isPalindromeApproach2(str));


    }
}
