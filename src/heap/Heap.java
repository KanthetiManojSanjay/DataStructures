package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
	
	// Below is an implementation for minHeap

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

	// O(LogN) hence deletion takes o(LogN)
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
		 int marks[] = {90,80,12,13,15,56,94};

	        Heap h = new Heap(marks.length);

	        for(int x:marks){
	            h.insert(x);
	        }

	        while(!h.isEmpty()){
	            System.out.println(h.getMin());
	            h.deleteMin(); //logn
	        }

	}

}
