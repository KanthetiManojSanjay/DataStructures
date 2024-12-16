package array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kansanja on 14/12/24.
 */
public class EncodeDecodeString {

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            list.add(str.substring(i, j));
            i = j;
        }
        return list;
    }

    public static void main(String[] args) {
//        List<String> str = Arrays.asList("neet", "code", "love", "you");
        List<String> str = Arrays.asList("we", "say", ":", "yes", "!@#$%^&*()");
        System.out.println(encode(str));
        List<String> res = decode(encode(str));
        for (String s : res) {
            System.out.println(s);
        }

    }

}
