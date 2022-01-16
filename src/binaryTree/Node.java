package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Node {
	static Scanner scanner = new Scanner(System.in);
	private int data;
	private Node left = null;
	private Node right = null;

	public Node(int data) {
		this.data = data;
	}

	public static Node buildTree() {

		int num = scanner.nextInt();
		if (num == -1) {
			return null;
		} else {
			Node node = new Node(num);
			node.left = buildTree();
			node.right = buildTree();
			return node;
		}

	}

	// Root -> Left -> Right
	public static void printPreorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	// Left -> Root -> Right
	public static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	// Left -> Right -> Root (Most popular for problems) - Also bottom up approach
	public static void printPostOrder(Node root) {
		if (root == null) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {
			Node temp = queue.peek();
			if (temp == null) {
				System.out.println();
				queue.poll();
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			} else {
				System.out.print(temp.data + " ");
				queue.poll();

				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
		}
	}

	public static Node levelorderBuild() {
		Scanner scanner2 = new Scanner(System.in);

		Queue<Node> queue = new LinkedList<>();

		Node root = new Node(scanner2.nextInt());
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node current = queue.peek();
			queue.poll();

			int c1 = scanner2.nextInt();
			int c2 = scanner2.nextInt();
			if (c1 != -1) {
				current.left = new Node(c1);
				queue.offer(current.left);
			}
			if (c2 != -1) {
				current.right = new Node(c2);
				queue.offer(current.right);
			}
		}

		return root;

	}

	public static int height(Node root) {
		if (root == null) {
			return 0;
		}

		int h1 = height(root.left);
		int h2 = height(root.right);
		return 1 + Math.max(h1, h2);
	}

	// Time complexity is O(N^2)as we are traversing twice for calculating height &
	// diameter
	public static int diameter(Node root) {
		if (root == null) {
			return 0;
		}

		int D1 = height(root.left) + height(root.right);
		int D2 = diameter(root.left);
		int D3 = diameter(root.right);
		return Math.max(D1, Math.max(D2, D3));
	}

	public static class HDPair {
		int diameter;
		int height;
//		public HDPair() {
//			super();
//			this.diameter=0;
//			this.height=0;
//		}
		
	}

	public static HDPair optDiameter(Node root) {
		HDPair p= new HDPair();

		if (root == null) {
			p.diameter = 0;
			p.height = 0;
			return p;
		}

		HDPair left = optDiameter(root.left);
		HDPair right = optDiameter(root.right);

		p.height = 1 + Math.max(left.height, right.height);

		int D1 = left.height + right.height;
		int D2 = left.diameter;
		int D3 = right.diameter;

		p.diameter = Math.max(D1, Math.max(D2, D3));
		return p;

	}
	
	public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			for (int node : path) {
				System.out.print(node + "->");
			}
			System.out.print(root.data+"->");
			System.out.println();
			return;
		}
		// rec case
		path.add(root.data);
		printRootToLeaf(root.left, path);
		printRootToLeaf(root.right, path);
		path.remove(path.size()-1);
	}


	public static void main(String[] args) {
		
		// 1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1

		Node root = buildTree();
		printPreorder(root);
		System.out.println();
		printInorder(root);
		System.out.println();
		printPostOrder(root);
		System.out.println();
		levelOrder(root);

		
		// 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1
		
//		Node r1 = levelorderBuild();
//		levelOrder(r1);
//		System.out.println("Height of the tree is : " + height(r1));
//		System.out.println("Diameter of the tree is : " + diameter(r1));
//		HDPair pair = optDiameter(r1);
//		System.out.println("Height of the tree is : " + pair.height + " & diameter of tree is :" + pair.diameter);
		
		// 1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1
		ArrayList<Integer> list =new ArrayList<>();
		printRootToLeaf(root,list);

	}

}
