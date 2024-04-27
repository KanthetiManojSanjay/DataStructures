package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author kansanja on 26/04/24.
 */
public class NonRepeatingLetter {

    public static void getNonRepeatingLetter(String str) {

        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            queue.add(ch);

            // remove all characters from the front till you get a char with frequency as 1
            while (!queue.isEmpty()) {
                Character front = queue.element();
                if (map.get(front) > 1) {
                    queue.remove();
                } else {
                    System.out.print(queue.element() + ",");
                    break;
                }
            }
            if (queue.isEmpty()) {
                System.out.print(-1 + ",");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str = "aabccbcd";
        getNonRepeatingLetter(str);

    }
}
