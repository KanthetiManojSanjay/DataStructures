package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class UniqueSubstring {

	public static String unqSubstr(String str) {
		int i = 0;
		int j = 0;
		int win_len = 0;
		int start_idx = -1;
		Map<Character, Integer> map = new HashMap<>();
		int max_win_len = 0;

		while (j < str.length()) {
			Character ch = str.charAt(j);
			if (map.containsKey(ch) && map.get(ch) > i) {
				i = map.get(ch) + 1;
				win_len = j - i;

			}
			map.put(ch, j);
			win_len++;
			j++;

			if (win_len > max_win_len) {
				max_win_len = win_len;
				start_idx = i;
			}
		}

		return str.substring(start_idx, start_idx + max_win_len);
	}

	public static void main(String[] args) {
		System.out.println(unqSubstr("prateekbhaiya"));
	}

}
