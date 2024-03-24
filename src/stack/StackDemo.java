package stack;

/**
 * @author kansanja on 07/03/24.
 */
public class StackDemo {
    public static void main(String[] args) throws Exception {
        StackUsingArray s = new StackUsingArray();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        while (!s.isEmpty()) {
            int top = s.peek();
            System.out.println(top);
            s.pop();
        }
        s.display();
    }
}
