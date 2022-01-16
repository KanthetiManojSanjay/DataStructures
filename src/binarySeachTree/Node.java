package binarySeachTree;

import java.util.ArrayList;
import java.util.List;

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

	
	public static void main(String[] args) {

		int[] arr = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };
		Node root = null;
		for (int a : arr) {
			root = insert(root, a);
		}

		printInOrder(root);
		System.out.println();
		System.out.println("Search element is " + search(root, 11));

		remove(root, 14);
		printInOrder(root);
		System.out.println();
		printRange(root, 5, 12);

	}

}
