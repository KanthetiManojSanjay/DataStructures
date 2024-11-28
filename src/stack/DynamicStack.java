package stack;

/**
 * @author kansanja on 07/03/24.
 */
public class DynamicStack extends StackUsingArray {

    public DynamicStack() throws Exception {
        this(DEFAULT_CAPACITY);
    }

    public DynamicStack(int capacity) throws Exception {
        super(capacity);
    }

    /**
     * 1st Approach(Below impl) - New Array is created with a double capacity of original array & copied all the elements from original array to newly created array
     * 2nd Approach - We can implement dynamic Array using ArrayList & Linked list inbuilt classes from collections (or) we can use LinkedList that we created earlier
     * <p>
     * With linkedList - we can do push by adding new item at the tail which can be done in O(1)
     * but while deleting as tail dont have prev Node reference we cant delete it in O(1) and we have traverse from head which can be O(N)
     * <p>
     * hence to solve the problem we can do push by adding new item at the head & delete the item from head - Both can be done in O(1)
     * by using the below methods of LinkedList class that we created earlier for stack functionality
     * i.e. Push - addFirst()
     * Pop - removeFirst()
     * Peek - getFirst()
     */
    @Override
    public void push(int item) throws Exception {
        if (getSize() == data.length) {
            int[] arr = new int[2 * data.length];
            for (int i = 0; i < getSize(); i++) {
                arr[i] = data[i];
            }
            data = arr;
            super.push(item);
        }
    }
}
