package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author kansanja on 03/12/24.
 */
public class RunningMedian {

    // O(LogN) for each insertion so O(NLogN) for complete problem
    public static void main(String[] args) {
        // 10 5 2 3 0 12 18 20 22 -1
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Comparator.reverseOrder()); // maxHeap
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>(); // minHeap
        float median = 0;
        if (d != -1) {
            leftHeap.add(d);
            median = d;
            System.out.print(median + " ");
        }

        int nextNum = sc.nextInt();
        while (nextNum != -1) {

            // If maxHeap size is greater than minHeap
            if (leftHeap.size() > rightHeap.size()) {
                // If next element is greater than current median & if the current median is present in maxHeap then perform rebalancing by adding
                // top element of maxHeap to minHeap and then delete it from maxHeap and then add that new element to maxHeap
                if (nextNum < median) {
                    rightHeap.add(leftHeap.peek());
                    leftHeap.poll();
                    leftHeap.add(nextNum);
                } else {
                    rightHeap.add(nextNum);
                }
                median = (leftHeap.peek() + rightHeap.peek()) / 2f;
            }
            // If both maxHeap & minHeap size are same
            else if (leftHeap.size() == rightHeap.size()) {
                if (nextNum < median) {
                    leftHeap.add(nextNum);
                    median = leftHeap.peek();
                } else {
                    rightHeap.add(nextNum);
                    median = rightHeap.peek();
                }
            }
            // If minHeap size is greater than maxHeap
            else {
                if (nextNum < median) {
                    leftHeap.add(nextNum);
                }
                // If next element is greater than current median & if the current median is present in minHeap then perform rebalancing by adding
                // top element of minHeap to maxHeap and then delete it from minHeap and then add the new element to maxHeap
                else {
                    leftHeap.add(rightHeap.peek());
                    rightHeap.poll();
                    rightHeap.add(nextNum);
                }
                median = (leftHeap.peek() + rightHeap.peek()) / 2f;
            }
            System.out.print(median + " ");
            nextNum = sc.nextInt();
        }
    }
}
