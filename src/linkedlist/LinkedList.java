package linkedlist;

public class LinkedList {
	Node head;
	Node tail;
	int size = 0;

	public class Node {
		int value;
		Node next;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

	public void insertAtFirst(int element) {
		Node node = new Node(element);
		node.next = head;
		head = node;
		if (tail == null) {
			tail = head;
		}
		size++;
	}
	
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.value +"->");
			temp=temp.next;
		}
		System.out.println("null");
	}

	public void insertAtLast(int element) {
		if (size == 0) {
			insertAtFirst(element);
			return;
		}
		Node node = new Node(element);
		tail.next = node;
		tail = node;
		size++;

	}
}
