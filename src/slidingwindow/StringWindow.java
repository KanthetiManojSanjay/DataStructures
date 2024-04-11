package slidingwindow;

import java.util.Arrays;

public class StringWindow {

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

    public static void main(String[] args) {
        String s = "hello";
        String p = "lhl";
        System.out.println(find_window(s, p));
    }

}
