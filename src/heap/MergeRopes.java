package heap;

import java.util.PriorityQueue;

/**
 * @author kansanja on 03/12/24.
 */
public class MergeRopes {

    private static int joinRopes(int[] ropes, int n) {

        //min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //initialise
        for (int rope : ropes) {
            queue.add(rope);
        }

        int cost = 0;
        while (queue.size() > 1) {

            int A = queue.peek();
            queue.poll();

            int B = queue.peek();
            queue.poll();

            int new_rope = A + B;
            cost += new_rope;
            queue.add(new_rope);

        }
        return cost;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        int n = 4;
        System.out.printf("Minimum cost to join ropes is %d%n", joinRopes(arr, n));
    }


}
