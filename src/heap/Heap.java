package heap;

import java.util.ArrayList;
import java.util.Collections;

/* Heap or Priority Queue
If we have pick top K aged people based on age from a list
If we use Sorting takes O(N LogN) but if we use Priority Queue takes O(N+KLogN)
 	i.e. O(N) for priority queue creation & O(KLogN) to remove K people from heap

 	Heap properties
 	1. It should be binary tree - Each node can have atmost 2 children
 	2. It is a Complete Binary Tree(CBT) - All levels of tree should be completely filled except last level which can be partially filled but must be filled from left to right order
 	3. Should follow Heap Order property(either minHeap or maxHeap)
 		maxHeap -> parent >= children
 		minHeap -> parent<=children
 	we will visualise Heap as Tree but we will implement it as an Array from memory representation pov
 	Reason: If we have to insert an element in BT then we have to do level order traversal just to identify where to place this element which will take O(N)
 	      which is not efficient hence BT representation is not best approach
 	      but we use Tree structure to maintain hierarchical structure b/w child & parent
 	      CBT has a special property i.e. we can flatten it as an array

*/
public class Heap {

    //Below is an implementation for minHeap

    private ArrayList<Integer> list;

    public Heap(int default_size) {
        list = new ArrayList<>(default_size + 1);
        list.add(-1);
    }

    // O(LogN) - time complexity
    public void insert(int data) {
        list.add(data);
        int idx = list.size() - 1;
        int parent = idx / 2;

        while (idx > 1 && list.get(parent) > list.get(idx)) {
            Collections.swap(list, idx, parent);
            idx = parent;
            parent = parent / 2;
        }

    }

    //O(1)
    public int getMin() {
        return list.get(1);
    }

    public void deleteMin() {
        int idx = list.size() - 1;
        Collections.swap(list, 1, idx);
        list.remove(idx);
        heapify(1);
    }

    // O(LogN) as maximum swapping happens which is equal to height of CBT
    private void heapify(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;

        int minIdx = i;

        if (left < list.size() && list.get(left) < list.get(i)) {
            minIdx = left;
        }
        if (right < list.size() && list.get(right) < list.get(minIdx)) {
            minIdx = right;
        }

        if (minIdx != i) {
            Collections.swap(list, i, minIdx);
            heapify(minIdx);
        }
    }

    public boolean isEmpty() {
        return list.size() == 1;
    }

    public static void main(String[] args) {
        int marks[] = {90, 80, 12, 13, 15, 56, 94};

        Heap h = new Heap(marks.length);

        for (int x : marks) {
            h.insert(x);
        }

        while (!h.isEmpty()) {
            System.out.println(h.getMin());
            h.deleteMin(); //logn
        }

    }

}
