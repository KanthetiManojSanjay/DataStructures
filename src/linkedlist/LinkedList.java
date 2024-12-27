package linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    LinkedList() {
        head = tail = null;
        size = 0;
    }


    // O(1)
    public void insertAtFirst(int element) {
        Node node = new Node(element);
        node.next = head;
        head = node;

        if (size == 0) {
            tail = node;
        }
        size++;
    }

    // O(1)
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

    // O(N)
    public void addAt(int data, int idx) {
        if (idx < 0 || idx > size) {
            throw new IllegalArgumentException("Index of bounds");
        }
        if (idx == 0) {
            insertAtFirst(data);
        } else if (idx == size) {
            insertAtLast(data);
        } else {
            Node temp = head;
            // In worst case we may need to iterate till end so O(N)
            for (int jump = 1; jump <= idx - 1; jump++) {
                temp = temp.next;
            }
            Node n = new Node(data);
            n.next = temp.next;
            temp.next = n;
            size++;
        }
    }

    // O(1)
    public int getSize() {
        return size;
    }

    // O(N)
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public int getFirst() {
        if (size == 0) {
            throw new IllegalArgumentException("Linked list is empty");
        }
        return head.value;
    }

    public int getLast() {
        if (size == 0) {
            throw new IllegalArgumentException("Linked list is empty");
        }
        return tail.value;
    }

    public int getAt(int idx) throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        } else if (idx < 0 || idx > size) {
            throw new Exception("Index of bounds");
        } else if (idx == 0) {
            return getFirst();
        } else if (idx == size - 1) {
            return getLast();
        } else {
            Node temp = head;
            for (int jump = 1; jump <= idx; jump++) {
                temp = temp.next;
            }
            return temp.value;
        }
    }

    // O(1)
    public int removeFirst() throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        }
        int output = head.value;
        if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
        return output;
    }

    // O(N)
    public int removeLast() throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        }
        int output = tail.value;
        if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            // As it is a singly linkedList so we dont have prev Node reference hence had to traverse from head hence O(N) time complexity
            // If we have Doubly linked list then we can traverse 1 step back i.e. prev which can be done in O(1)
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }
        return output;
    }

    //O(N) - worstcase if the index is the last element
    public int removeAt(int idx) throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        }
        if (idx < 0 || idx >= size) {
            throw new Exception("Index of bounds");
        }
        if (idx == 0) {
            return removeFirst();
        } else if (idx == size - 1) {
            return removeLast();
        } else {
            Node temp = head;
            for (int jump = 1; jump < idx; jump++) {
                temp = temp.next;
            }
            Node output = temp.next;
            temp.next = output.next;
            output.next = null;
            size--;
            return output.value;
        }
    }


    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node sHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return sHead;
    }

    public void reverseItr() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;

    }

    public void reverse() {
        Node node = reverse(head);
        head = node;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println("");

    }

    public Node kReverse(Node node, int k) {

        //Base case
        if (node == null)
            return null;

        Node prev = null;
        Node curr = node;
        Node temp = null;
        int cnt = 1;
        while (curr != null && cnt <= k) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            cnt++;
        }
        if (temp != null) {
            node.next = kReverse(temp, k);
        }
        return prev;
    }

    public void kReverse(int k) {
        head = kReverse(head, k);
        display();
    }

    // Time & Space complexity -> O(N+M)
    private Node merge(Node a, Node b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node temp = null;
        if (a.value < b.value) {
            temp = a;
            temp.next = merge(a.next, b);
        } else if (a.value > b.value) {
            temp = b;
            temp.next = merge(a, b.next);
        }
        return temp;
    }

    public void mergeFun(LinkedList l1, LinkedList l2) {
        Node a = l1.head;
        Node b = l2.head;
        Node temp = merge(a, b);
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println("");
    }

    // TimeComplexity - O(N)
    public void middle() {
        // Node fastPtr=head.next - Incase if in even numbers (1->2->3->4) then o/p is 2
        Node fastPtr = head; // Here o/p is 3 & for odd no's there is no impact
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println(slowPtr.value);
    }

    private Node midPoint(Node node) {
        Node slowPtr = node;
        Node fastPtr = node.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null)
            return node;

        Node mid = midPoint(node);
        Node a = node;
        Node b = mid.next;
        mid.next = null;

        a = mergeSort(a);
        b = mergeSort(b);

        return merge(a, b);

    }

    public void sortLL(LinkedList list) {
        Node head = list.head;
        Node node = mergeSort(head);
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.print("");
    }

    public boolean detectCycle() {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }

        }
        return false;
    }

    public Node reorderList(Node head) {

        Node mid = midPoint(head);
        Node second = reverse(mid.next);


        Node temp=head;
        while(head!=null){
            if(head==mid)
                head.next=null;
            head=head.next;
        }
        Node first = temp;
        while (second != null) {
            Node tmp1 = first.next;
            Node tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        return temp;
    }

    public void reorderList(LinkedList list) {
        Node node = reorderList(list.head);
        System.out.println("Reordered list");
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.print("");

    }

}
