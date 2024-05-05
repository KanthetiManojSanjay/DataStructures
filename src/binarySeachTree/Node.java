package binarySeachTree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        super();
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    //	Inorder traversal of binary search tree will be a sorted
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    /*
     * Time complexity is O(H). It it not O(LogN) bcz there can skewed trees which
     * will have TC as O(N) So O(LogN)<=O(H)<=O(N)
     */
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.data) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node remove(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.data) {
            root.left = remove(root.left, key);
        } else if (key > root.data) {
            root.right = remove(root.right, key);
        } else {
            // when current node matches current Node data

            // No children
            if (root.left == null && root.right == null) {
                root = null;
            }

            // single child
            else if (root.left == null) {
                Node temp = root.right;
                root = root.right;
            } else if (root.right == null) {
                Node temp = root.left;
                root = root.left;
            }

            // Two children
            else {
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = remove(root.right, temp.data);
            }
        }
        return root;
    }

    private static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        } else if (k2 < root.data) {
            printRange(root.left, k1, k2);
        } else {
            printRange(root.right, k1, k2);
        }
    }


    // If we normally create BST from sortedArray then it creates skewed tree of height O(N) & O(N^2) time complexity so we can create minheight balanced tree
    public static Node minHeightBST(int[] arr, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = minHeightBST(arr, start, mid - 1);
        root.right = minHeightBST(arr, mid + 1, end);
        return root;
    }

    public static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static int closestInBST(Node root, int target) {

        int diff = Integer.MAX_VALUE;
        Node temp = root;
        int closest = 0;
        while (temp != null) {
            int current_diff = Math.abs(temp.data - target);

            if (current_diff == 0)
                return temp.data;

            if (current_diff < diff) {
                diff = current_diff;
                closest = temp.data;
            }

            // right or left
            if (temp.data < target) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return closest;
    }


    class LinkedList1 {
        Node head;
        Node tail;

        public LinkedList1() {
            head = tail = null;
        }
    }

    public LinkedList1 tree2LL(Node root) {

        LinkedList1 l = new LinkedList1();
        //base case
        if (root == null) {
            l.head = l.tail = null;
            return l;
        }

        // rec cases
        if (root.left == null && root.right == null) {
            l.head = l.tail = root;
        } else if (root.left != null && root.right == null) {
            LinkedList1 leftLL = tree2LL(root.left);
            leftLL.tail.right = root;

            l.head = leftLL.head;
            l.tail = root;
        } else if (root.left == null && root.right != null) {
            LinkedList1 rightLL = tree2LL(root.right);
            root.right = rightLL.head;
            l.head = root;
            l.tail = rightLL.tail;
        } else if (root.left != null && root.right != null) {
            LinkedList1 leftLL = tree2LL(root.left);
            LinkedList1 rightLL = tree2LL(root.right);

            leftLL.tail.right = root;
            root.right = rightLL.head;
            l.head = leftLL.head;
            l.tail = rightLL.tail;
        }
        return l;
    }


    public static Node inOrderSuccessor(Node root, Node target) {

        // If right subtree
        if (target.right != null) {
            Node temp = target.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        // Otherwise
        Node temp = root;
        Node succ = null;
        while (temp != null) {
            if (temp.data > target.data) {
                succ = temp;
                temp = temp.left;
            } else if (temp.data < target.data) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return succ;
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        Node root = null;
        for (int a : arr) {
            root = insert(root, a);
        }

        /*printInOrder(root);
        System.out.println();
        System.out.println("Search element is " + search(root, 11));

        remove(root, 14);
        printInOrder(root);
        System.out.println();
        printRange(root, 5, 12);

        System.out.println();
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        int start = 0;
        int end = arr1.length - 1;
        Node root1 = minHeightBST(arr1, start, end);
        printLevelOrder(root1);*/

       /* int target = 17;
        System.out.printf("Closest element for target %d in BST is %d%n", target, closestInBST(root, target));*/


      /*  LinkedList1 linkedList = root.tree2LL(root);
        Node temp = linkedList.head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.right;
        }*/

        System.out.println();
        System.out.println("Inorder successor of 7 is: " + inOrderSuccessor(root, root.left.right.right).data);
        System.out.println("Inorder successor of 10 is: " + inOrderSuccessor(root, root.right).data);


    }

}
