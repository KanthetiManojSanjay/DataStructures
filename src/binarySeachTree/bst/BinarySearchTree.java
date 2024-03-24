package binarySeachTree.bst;

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

public class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        this.root = buildTree();
    }

    private Node buildTree() {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        Node root = null;
        while (d != -1) {
            root = insert(root, d);
            d = sc.nextInt();
        }
        return root;
    }

    // Input -> 8 3 10 1 6 14 4 13 7 -1
    private Node insert(Node root, int key) {
        //base case
        if (root == null) {
            return new Node(key);
        }
        if (key <= root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    void inOrderPrint(Node root) {
        //base case
        if (root == null) {
            return;
        }

        inOrderPrint(root.left);
        System.out.println(root.data);
        inOrderPrint(root.right);
    }

    void display() {
        inOrderPrint(root);
    }


    // Worst case i.e. skewed tree search will be O(N)
    // If the tree is balanced tree then search will be O(LogN)
    boolean search(int key) {
        return searchFn(root, key);
    }

    boolean searchFn(Node root, int key) {
        //base case
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }

        if (key <= root.data) {
            return searchFn(root.left, key);
        } else {
            return searchFn(root.right, key);
        }

    }

    void removeKey(int key) {
        remove(root, key);
    }

    Node remove(Node root, int key) {
        //base case
        if (root == null) {
            return null;
        }

        //rec case
        if (key < root.data) {
            root.left = remove(root.left, key);
        } else if (key > root.data) {
            root.right = remove(root.right, key);
        } else {
            // this is the node to be deleted

            //case 1. no children
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 3 two child
            else {

                Node temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                root.data = temp.data;
                root.left = remove(root.left, temp.data);
            }

        }
        return root;
    }
}
