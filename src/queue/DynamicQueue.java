package queue;

/**
 * @author kansanja on 07/03/24.
 */

/**
 * Below is the Queue implementation using Dynamic Array
 * We can also implement the same using ArrayList or LinkedList as well similarly

  Queue interface in java( enqueue, dequeue, peek operations)

  Operation    Throws Exception     Returns special value(returns boolean value)
  ---------------------------------------------------------------------------
  Insert         add(e)              offer(e)
  Remove        remove()             poll()
  Examine       element()            peek()

 3 implementation of Queue interface are
 Linked list -  FIFO
 Array dequeue - insert & remove from both ends(i.e. doubly ended queue)
 Priority queue - based on heap DS. Maintains priority order than FIFO ordering
 **/

public class DynamicQueue extends Queue {
    public DynamicQueue() throws Exception {
        this(DEFAULT_CAPACITY);
    }

    public DynamicQueue(int capacity) throws Exception {
        super(capacity);
    }

    @Override
    public void enqueue(int value) throws Exception {
        if (size == data.length) {
            int[] temp = new int[2 * data.length];
            for (int i = 0; i < size; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            data = temp;
            front = 0;
        }
        super.enqueue(value);
    }
}
