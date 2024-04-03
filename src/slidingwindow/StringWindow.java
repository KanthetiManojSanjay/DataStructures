package slidingwindow;

public class StringWindow {

    private static String find_window(String s, String p) {

        int FP[] = new int[256];
        int FS[] = new int[256];

        for (int i = 0; i < p.length(); i++) {
            FP[p.charAt(i)]++;
        }

        int count = 0;
        int start = 0;
        int start_idx = -1;
        int min_so_far = Integer.MAX_VALUE;
        int window_size;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //expand the window by including current character
            FS[ch]++;

            // count how many characters are matching till now
            if (FP[ch] != 0 && FS[ch] <= FP[ch]) {
                count += 1;
            }

            // if all characters of pattern are present in the current window then you can start contracting
            if (count == p.length()) {

                //start contracting from left to remove unwanted characters from window
                while (FP[s.charAt(start)] == 0 || FS[s.charAt(start)] > FP[s.charAt(start)]) {
                    FS[s.charAt(start)]--;
                    start++;
                }

                //note the window size
                window_size = i - start + 1;
                if (window_size < min_so_far) {
                    min_so_far = window_size;
                    start_idx = start;
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
