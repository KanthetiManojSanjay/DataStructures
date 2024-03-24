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
     * 2nd Approach - We can implement dynamic Array using ArrayList & Linked list inbuilt classes from collections
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
