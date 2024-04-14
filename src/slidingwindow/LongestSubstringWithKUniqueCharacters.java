package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 12/04/24.
 */
public class LongestSubstringWithKUniqueCharacters {

    private static int findLengthOfLongestSubstringWithKUniqueCharacters(String s, int k) {

        int win_start = 0;
        Map<Character, Integer> windowCharCount = new HashMap<>(); // Stores the character count for each character in the current window
        int maxLen = -1; // Stores the length of the longest substring with k unique characters found so far.

        for (int win_end = 0; win_end < s.length(); win_end++) {
            // Add the next character to the sliding window
            char ch = s.charAt(win_end);
            windowCharCount.put(ch, windowCharCount.getOrDefault(ch, 0) + 1);

            // Shrink the sliding window, until we have exactly 'k' distinct characters in the window
            while (windowCharCount.size() > k) {
                char leftChar = s.charAt(win_start);

                // Discard the character at windowStart since we're gonna move it out of the window now.
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (windowCharCount.get(leftChar) == 0) {
                    windowCharCount.remove(leftChar);
                }
                win_start++; // Shrink the window
            }

            if (windowCharCount.size() == k) {
                maxLen = Math.max(maxLen, win_end - win_start + 1);
            }


        }
        return maxLen;
    }


    public static void main(String[] args) {
        String S = "aabacbebebe";
        int K = 3;
        System.out.println(findLengthOfLongestSubstringWithKUniqueCharacters(S, K));
    }
}
