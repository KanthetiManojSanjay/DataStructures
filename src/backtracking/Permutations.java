package backtracking;

/**
 * @author kansanja on 20/04/24.
 */
public class Permutations {

    private static void solve(char[] arr, int idx) {

        if (idx == arr.length - 1) { //Base condition of recursion
            System.out.print(String.valueOf(arr) + " ");
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            solve(arr, idx + 1);
            swap(arr, idx, i);
            //Backtracking: reverting all the elements to their original places
        }

    }

    //swap function to swap two characters from indices idx and idx2
    public static void swap(char[] arr, int idx, int idx2) {
        char temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        char[] in = "abc".toCharArray();
        solve(in, 0);
    }
}
