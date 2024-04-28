package binaryTree.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author kansanja on 09/03/24.
 */

class Node {
    int data;
    Node left;
    Node right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

public class BinaryTree {

    Node root;

    BinaryTree() {
        Scanner sc = new Scanner(System.in);
        root = createTree(sc);
    }

    Node createTree(Scanner sc) {
        int data = sc.nextInt();
        // base case
        if (data == -1) {
            return null;
        }
        Node n = new Node(data);
        n.left = createTree(sc);
        n.right = createTree(sc);
        return n;
    }

    void display() {
        //preOrderPrint(root);
        // inOrderPrint(root);
        postOrderPrint(root);
        // levelorderPrint(root);
    }

    private void preOrderPrint(Node root) {
        //base case
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    private void inOrderPrint(Node root) {
        //base case
        if (root == null) {
            return;
        }
        inOrderPrint(root.left);
        System.out.println(root.data);
        inOrderPrint(root.right);
    }


    private void postOrderPrint(Node root) {
        //base case
        if (root == null) {
            return;
        }
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.data);
    }

    public static void levelorderPrint(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

        }
    }

    public static Node levelOrderBuild() {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(sc.nextInt());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int left = sc.nextInt();
            int right = sc.nextInt();
            if (left != -1) {
                current.left = new Node(left);
                queue.offer(current.left);
            }
            if (right != -1) {
                current.right = new Node(right);
                queue.offer(current.right);
            }
        }
        return root;
    }

}
