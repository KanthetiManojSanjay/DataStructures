package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 11/04/24.
 */
public class AnagramCount {

    public static int count_BruteForce(String text, String word) {
        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        int n = text.length();
        int k = word.length();
        int count = 0;

        for (int i = 0; i <= n - k; i++) {
            Map<Character, Integer> textMap = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                char ch = text.charAt(j);
                textMap.put(ch, textMap.getOrDefault(ch, 0) + 1);
            }
            if (isAnagram(textMap, wordMap)) {
                count++;
            }
        }
        return count;
    }


    public static int count_slidingWindow(String text, String word) {

        // Calculate the count of each character for the given word
        Map<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        int win_start = 0;
        // Stores the character count for the current substring (current window)
        Map<Character, Integer> textMap = new HashMap<>();
        int count = 0;
        for (int win_end = 0; win_end < text.length(); win_end++) {
            char ch = text.charAt(win_end);
            textMap.put(ch, textMap.getOrDefault(ch, 0) + 1); // Include the next char in the window

            if (win_end - win_start + 1 == word.length()) { // We've hit the window size. Calculate result and Slide the window
                if (isAnagram(textMap, wordMap)) {
                    count++;
                }

                // Reduce count for the char at windowStart since we are sliding the window now
                textMap.put(text.charAt(win_start), textMap.get(text.charAt(win_start)) - 1);
                win_start++; // Slide the window ahead
            }
        }
        return count;
    }

    private static boolean isAnagram(Map<Character, Integer> textMap, Map<Character, Integer> wordMap) {
        // Two words are anagrams of each other if the count of every character in both the words are same.
        for (Character ch : wordMap.keySet()) {
            if (wordMap.get(ch) != textMap.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String text = "forxxorfxdofr", word = "for";
        String text = "aabaabaa", word = "aaba";
        System.out.println("Count of Anagrams by Bruteforce Approach is: " + count_BruteForce(text, word));
        System.out.println("Count of Anagrams by SlidingWindow Approach is: " + count_slidingWindow(text, word));
    }
}
