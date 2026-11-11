package array.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 09/04/24.
 */
public class ValidAnagram {

    /*
    For below both implementations, time complexity is O(n+m) and space complexity is O(1)
    as we are using fixed size array of 26 for counting the characters
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer count : countMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean checkAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (Integer val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
//        System.out.println(isAnagram(s, t));
        System.out.println(checkAnagram(s, t));

    }
}
