package queue;

/**
 * @author kansanja on 07/03/24.
 */
public class QueueTest {
    public static void main(String[] args) throws Exception {
/*        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(6);
        queue.enqueue(7);
        queue.display();*/



        Queue dynamicQueue = new DynamicQueue(5);
        dynamicQueue.enqueue(1);
        dynamicQueue.enqueue(2);
        dynamicQueue.enqueue(3);
        dynamicQueue.enqueue(4);
        dynamicQueue.enqueue(5);
        dynamicQueue.enqueue(6);

        dynamicQueue.dequeue();
        dynamicQueue.dequeue();

        dynamicQueue.enqueue(7);
        dynamicQueue.enqueue(8);
        dynamicQueue.display();

    }
}
