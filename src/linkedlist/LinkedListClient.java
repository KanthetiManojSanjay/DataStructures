package linkedlist;

public class LinkedListClient {
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);
        list.display();
        list.addAt(0, 0);
        list.addAt(100, list.getSize());
        list.display();
        list.addAt(4, 3);
        list.display();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getAt(4));
        System.out.println(list.removeFirst());
        list.display();
        System.out.println(list.getSize());
        System.out.println(list.removeLast());
        list.display();
        System.out.println(list.removeAt(2));
        list.display();

        list.reverseItr();
        list.display();

        list.reverse();
        System.out.println("kReverse");
        list.kReverse(3);

        // 1->5->7->10
        LinkedList list1 = new LinkedList();
        list1.insertAtFirst(10);
        list1.insertAtFirst(7);
        list1.insertAtFirst(5);
        list1.insertAtFirst(1);

        // 2->3->6
        LinkedList list2 = new LinkedList();
        list2.insertAtFirst(6);
        list2.insertAtFirst(3);
        list2.insertAtFirst(2);

        // 1->2->3->5->6->7->10
        list1.mergeFun(list1, list2);

        list1.middle();

		/*14 -> 2 -> 17 -> 1 -> 5 -> 7 ->10
		
		Merge sort - 1->2->5->7->10->14->17
		
		*/
        LinkedList list3 = new LinkedList();
        list3.insertAtFirst(10);
        list3.insertAtFirst(7);
        list3.insertAtFirst(5);
        list3.insertAtFirst(1);
        list3.insertAtFirst(17);
        list3.insertAtFirst(2);
        list3.insertAtFirst(14);
        list3.sortLL(list3);

        LinkedList list4 = new LinkedList();
        list4.insertAtFirst(2);
        list4.insertAtLast(4);
        list4.insertAtLast(6);
        list4.insertAtLast(8);
        list4.insertAtLast(10);

        LinkedList list5 = new LinkedList();
        list5.insertAtFirst(0);
        list5.insertAtLast(1);
        list5.insertAtLast(2);
        list5.insertAtLast(3);
        list5.insertAtLast(4);
        list5.insertAtLast(5);
        list5.insertAtLast(6);
        list5.reorderList(list5);


    }

}
