package array.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 09/04/24.
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        char[] scharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();
        Map<Character, Integer> count = new HashMap<>();


        for (int i = 0; i < scharArray.length; i++) {
            count.put(scharArray[i], count.getOrDefault(scharArray[i], 0) + 1);
        }

        for (int i = 0; i < tcharArray.length; i++) {
            count.put(tcharArray[i], count.getOrDefault(tcharArray[i], 0) - 1);
        }

        for (int x : count.values()) {
            if (x != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println(isAnagram(s, t));

    }
}
