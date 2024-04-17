package binarySearch;

/**
 * @author kansanja on 17/04/24.
 */
// This problem is a variation of ceil of Sorted Array
public class NextLetter {
    private static int findNextLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0;
        int end = n - 1;

        char next = letters[start];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < letters[mid]) {
                /*
                 * letters[mid] is the smallest letter found so far that is greater than target.
                 * So update nextLetter to this value and keep checking in the left side of the
                 * array to find an even smaller letter that is greater than target
                 */
                next = letters[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        char letters[] = {'d', 'h', 'l'};
        char target = 'a';
        System.out.printf("Next smallest letter greater than %c is: %c%n", target, findNextLetter(letters, target));
    }
}
