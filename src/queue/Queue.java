package queue;

/**
 * @author kansanja on 07/03/24.
 */

// Queue implementation using Fixed sized Array(Circular queue)
public class Queue {
    protected int[] data;
    protected int size;
    protected int front;
    public static final int DEFAULT_CAPACITY = 10;

    public Queue() throws Exception {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) throws Exception {
        if (capacity < 1) {
            throw new Exception("Invalid capacity");
        }
        this.data = new int[capacity];
        this.size = 0;
        this.front = 0;
    }

    public void enqueue(int value) throws Exception {
        if (data.length == size) {
            throw new Exception("Queue is full");
        }
        int rear = (front + size) % data.length;
        data[rear] = value;
        size++;

    }

    public int dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        }
        int output = data[front];
        front = (front + 1) % data.length;
        size--;
        return output;
    }

    public int peek() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() throws Exception {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }

    public void display() {
        //System.out.println(Arrays.toString(data));

        for (int i = 0; i < size; i++) {
            int idx = (front + i) % data.length;
            System.out.print(data[idx] + ",");
        }
        System.out.println();
    }

}
