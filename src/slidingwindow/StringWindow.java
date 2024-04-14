package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringWindow {

    // Approach 1
    private static String find_window(String s, String p) {

        int FP[] = new int[256];
        int FS[] = new int[256];
        Arrays.fill(FS, 0);
        Arrays.fill(FP, 0);

        for (int i = 0; i < p.length(); i++) {
            FP[p.charAt(i)]++;
        }

        int i = 0, j = 0;
        int count = 0;
        int start_idx = -1;
        int min_so_far = Integer.MAX_VALUE;
        int window_size;

        while (j < s.length()) {
            char ch = s.charAt(j);
            //expand the window by including current character
            FS[ch]++;

            // count how many characters are matching till now
            if (FP[ch] != 0 && FS[ch] <= FP[ch]) {
                count += 1;
            }
            j++;
            // if all characters of pattern are present in the current window then you can start contracting
            if (count == p.length()) {

                //start contracting from left to remove unwanted characters from window
                while (FP[s.charAt(i)] == 0 || FS[s.charAt(i)] > FP[s.charAt(i)]) {
                    FS[s.charAt(i)]--;
                    i++;
                }

                //note the window size
                window_size = j - i; // j is already incremented above so ideally the formula should be j-1-i+1 which is reduced to j-i
                if (window_size < min_so_far) {
                    min_so_far = window_size;
                    start_idx = i;
                }
            }
        }
        if (start_idx == -1) {
            return "No window found";
        }
        return s.substring(start_idx, start_idx + min_so_far);
    }

    // Approach 2
    private static String findMinimumWindowSubstring(String s, String t) {

        int n = s.length();

        // length of the minumum window substring (smallest substring of s containing all the characters of t)
        int minWindowSubstrLength = Integer.MAX_VALUE;

        // start index of the minimum window substring
        int minWindowSubstrStart = 0;

        int win_start = 0;

        // stores the count of each character in the string t
        Map<Character, Integer> substrMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            substrMap.put(ch, substrMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowCharMap = new HashMap<>(); // Stores the character count for each character in the current window

        for (int win_end = 0; win_end < n; win_end++) {
            // Add the next character to the sliding window
            char ch = s.charAt(win_end);
            windowCharMap.put(ch, windowCharMap.getOrDefault(ch, 0) + 1);

            // Keep looking for a smaller window while the current window substring contains all the characters of t
            while (containsAll(windowCharMap, substrMap)) {

                if (win_end - win_start + 1 < minWindowSubstrLength) {
                    minWindowSubstrLength = win_end - win_start + 1;
                    minWindowSubstrStart = win_start;
                }

                // move the leftmost character out of the window
                char leftChar = s.charAt(win_start);
                windowCharMap.put(leftChar, windowCharMap.get(leftChar) - 1);
                if (windowCharMap.get(leftChar) == 0) {
                    windowCharMap.remove(leftChar);
                }
                win_start++; // Shrink the window
            }
        }
        return s.substring(minWindowSubstrStart, minWindowSubstrStart + minWindowSubstrLength);
    }

    private static boolean containsAll(Map<Character, Integer> windowCharMap, Map<Character, Integer> substrMap) {
        for (Map.Entry<Character, Integer> entry : substrMap.entrySet()) {
            Character key = entry.getKey();
            Integer count = entry.getValue();
            if (!windowCharMap.containsKey(key)) {
                return false;
            }
            if (windowCharMap.get(key) < count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "hello";
        String p = "lhl";
        System.out.println(find_window(s, p));

        String s2 = "ADOBECODEBANC", t2 = "ABC";
        System.out.printf("Minimum window substring = %s%n", findMinimumWindowSubstring(s2, t2));


    }

}
