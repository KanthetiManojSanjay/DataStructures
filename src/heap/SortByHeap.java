package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kansanja on 01/12/24.
 */
public class SortByHeap {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // By default it is minHeap
        PriorityQueue<Integer> priorityQueueAsc = new PriorityQueue<>();

        for (int x : arr) {
            priorityQueueAsc.add(x);
        }

        System.out.println("-------Minheap------");
        while (!priorityQueueAsc.isEmpty()) {
            System.out.print(priorityQueueAsc.peek() + " ");
            priorityQueueAsc.poll();
        }


        // MaxHeap
        PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<>(Comparator.reverseOrder());

        for (int x : arr) {
            priorityQueueDesc.add(x);
        }

        System.out.println();
        System.out.println("-------Maxheap------");
        while (!priorityQueueDesc.isEmpty()) {
            System.out.print(priorityQueueDesc.peek() + " ");
            priorityQueueDesc.poll();
        }


        PriorityQueue<Integer> customQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //Descending order
            }
        });

        for (int x : arr) {
            customQueue.add(x);
        }

        System.out.println();
        System.out.println("-------MaxHeap using custom comparator------");
        while (!customQueue.isEmpty()) {
            System.out.print(customQueue.peek() + " ");
            customQueue.poll();
        }

    }


    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 13, 6, 90};
        heapSort(arr);
    }
}
