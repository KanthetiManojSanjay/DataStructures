package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();;

	private void push(int a) {
		if (!q1.isEmpty()) {
			q1.add(a);
		} else {
			q2.add(a);
		}
	}

	private void pop() {
		if (q1.isEmpty()) {
			while (!q2.isEmpty()) {
				int front = q2.peek();
				q2.remove();
				if (q2.isEmpty()) {
					break;
				}
				q1.add(front);
			}
		} else if (q2.isEmpty()) {
			while (!q1.isEmpty()) {
				int front = q1.peek();
				q1.remove();

				if (q1.isEmpty()) {
					break;
				}
				q2.add(front);
			}
		}
	}

	private int top() {
		if (q1.isEmpty()) {
			while (!q2.isEmpty()) {
				int front = q2.peek();
				q2.remove();
				q1.add(front);
				if (q2.isEmpty()) {
					return front;
				}
				
			}
		} else if (q2.isEmpty()) {
			while (!q1.isEmpty()) {
				int front = q1.peek();
				q1.remove();
				q2.add(front);
				if (q1.isEmpty()) {
					return front;
				}
				
			}
		}
		return -1;
	}

	private boolean isEmpty() {
		return (q1.isEmpty() && q2.isEmpty());
	}

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.pop();

		while(!stack.isEmpty()) {
			System.out.println("Top of the stack element is :" + stack.top());
			stack.pop();
		}
		
	}

}
