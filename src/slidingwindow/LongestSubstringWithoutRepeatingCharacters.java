package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 14/04/24.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /*  Variant of Longest Substring with K unique characters
      Here it is Longest substring with ALL unique characters
     (So compare against the whole window length windowEnd-windowStart+1 instead of k)*/
    private static int findLengthOfLongestSubstringWithoutRepeatingCharacters(String s) {

        int maxLen = 0; // Stores the length of the longest substring without repeating characters so far.
        int win_start = 0;
        Map<Character, Integer> windowCharCount = new HashMap<>(); // stores the character count of each charcater in the current window
        for (int win_end = 0; win_end < s.length(); win_end++) {
            char ch = s.charAt(win_end);
            windowCharCount.put(ch, windowCharCount.getOrDefault(ch, 0) + 1);

            // Discard the character at the window start since we're gonna move it out of the window now
            while (windowCharCount.size() < win_end - win_start + 1) {
                char c = s.charAt(win_start);
                windowCharCount.put(c, windowCharCount.get(c) - 1);
                if (windowCharCount.get(c) == 0) {
                    windowCharCount.remove(c);
                }
                win_start++; // shirnk the window
            }

            // we have a window where all the characters are unique, Update the maxLength
            if (windowCharCount.size() == win_end - win_start + 1) {
                maxLen = Math.max(maxLen, win_end - win_start + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "aababcbb";
        System.out.printf("Longest substring without repeating characters = %d%n", findLengthOfLongestSubstringWithoutRepeatingCharacters(s1));

        String s2 = "cccc";
        System.out.printf("Longest substring without repeating characters = %d%n", findLengthOfLongestSubstringWithoutRepeatingCharacters(s2));

        String s3 = "";
        System.out.printf("Longest substring without repeating characters = %d%n", findLengthOfLongestSubstringWithoutRepeatingCharacters(s3));
    }
}
