package stack;

/**
 * @author kansanja on 07/03/24.
 */
public class StackUsingArray {
    protected int[] data;
    protected int top;
    public static final int DEFAULT_CAPACITY = 10;

    StackUsingArray() {
        data = new int[DEFAULT_CAPACITY];
        top = -1;
    }

    StackUsingArray(int capacity) throws Exception {
        if (capacity < 1) {
            throw new Exception("Invalid stack capacity");
        }
        data = new int[capacity];
        top = -1;
    }

    public int getSize() {
        return top + 1;
    }

    public void push(int item) throws Exception {
        if (getSize() == data.length) {
            throw new Exception("Stack is full");
        }
        top++;
        data[top] = item;
    }

    public int pop() throws Exception {
        if (getSize() == 0) {
            throw new Exception("Stack is empty");
        }
        int ans = data[top];
        data[top] = 0;
        top--;
        return ans;
    }

    public int peek() throws Exception {
        if (getSize() == 0) {
            throw new Exception("Stack is empty");
        }
        return data[top];
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

}
