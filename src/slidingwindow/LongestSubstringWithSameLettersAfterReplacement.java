package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 14/04/24.
 */
public class LongestSubstringWithSameLettersAfterReplacement {
    private static int findLengthOfLongestSubstringWithSameLettersAfterReplacement(String s, int k) {

        // length of longest substring with same charcaters repeated
        int maxLen = -1;

        //character count of each character in the current window
        Map<Character, Integer> windowCharCount = new HashMap<>();

        int win_start = 0;
        for (int win_end = 0; win_end < s.length(); win_end++) {
            // Add the next character to the window
            char ch = s.charAt(win_end);
            windowCharCount.put(ch, windowCharCount.getOrDefault(ch, 0) + 1);

            // calculate the max repeating character in the current window
            int maxRepeatingCharCount = getMaxRepeatLetterCount(windowCharCount);

             /*
            The current window has a letter that repeats 'maxRepeatLetterCount' times.
            If the remaining letters in the window are less than or equal to k then we can replace them all.
            Otherwise, we need to shrink the window since we are not allowed to replace more than 'k' letters.
            */
            while (win_end - win_start + 1 - maxRepeatingCharCount > k) {
                char c = s.charAt(win_start);
                windowCharCount.put(c, windowCharCount.get(c) - 1);
                if (windowCharCount.get(c) == 0) {
                    windowCharCount.remove(c);
                }
                win_start++;
            }

           /*  At this point, the number of remaining letters in the window are less than or equal to k.
            So we can replace them all to obtain a substring with same letters.
             Update the max length if the current window size is longer.*/
            maxLen = Math.max(maxLen, win_end - win_start + 1);
        }
        return maxLen;
    }

    private static int getMaxRepeatLetterCount(Map<Character, Integer> charCount) {
        int maxCount = 0;
        for (Integer count : charCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s1 = "abcababb";
        int k1 = 2;
        System.out.printf("Longest substring with same letters after replacement = %d%n", findLengthOfLongestSubstringWithSameLettersAfterReplacement(s1, k1));

        String s2 = "abccde";
        int k2 = 1;
        System.out.printf("Longest substring with same letters after replacement = %d%n", findLengthOfLongestSubstringWithSameLettersAfterReplacement(s2, k2));

    }
}
