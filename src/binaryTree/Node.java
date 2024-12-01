package binaryTree;

import java.util.*;

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

    // Time complexity is O(N^2)as we are traversing twice for calculating height & diameter
    // Diameter is largest distance between two nodes
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        // If diameter lies through root then LH-1+ RH-1 + 2
        int D1 = height(root.left) + height(root.right);
        int D2 = diameter(root.left); // If diameter lies in LH
        int D3 = diameter(root.right); // If diamter lies in RH
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

    // TimeComplexity - O(N)
    public static HDPair optDiameter(Node root) {
        HDPair p = new HDPair();

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
            System.out.print(root.data);
            System.out.println();
            return;
        }
        // rec case
        path.add(root.data);
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static int replaceWithDescendantSum(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }
        int leftSum = replaceWithDescendantSum(root.left);
        int rightSum = replaceWithDescendantSum(root.right);

        int temp = root.data;
        root.data = leftSum + rightSum;
        return root.data + temp;
    }

    public static class HBPair {
        int height;
        boolean isBalanced;
    }

    // height balanced tree - Height difference b/w Left & right subTree should be <=1
    public static HBPair heightBalancedTree(Node root) {

        HBPair hb = new HBPair();
        if (root == null) {
            hb.height = 0;
            hb.isBalanced = true;
            return hb;
        }

        HBPair left = heightBalancedTree(root.left);
        HBPair right = heightBalancedTree(root.right);

        hb.height = 1 + Math.max(left.height, right.height);

        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1)
            hb.isBalanced = true;

        return hb;

    }

    public static class MaxSubSumPair {
        int inc;
        int exc;
    }


    // Max subsetSum - If a node is considered then its parent/child shouldn't be considered to calculate maxSubsetSum
    public static MaxSubSumPair maximumSubSetSumTree(Node root) {
        MaxSubSumPair sumPair = new MaxSubSumPair();
        //base case
        if (root == null) {
            sumPair.inc = 0;
            sumPair.exc = 0;
            return sumPair;
        }
        //rec case
        MaxSubSumPair left = maximumSubSetSumTree(root.left);
        MaxSubSumPair right = maximumSubSetSumTree(root.right);

        sumPair.inc = root.data + left.exc + right.exc;
        sumPair.exc = Math.max(left.inc, left.exc) + Math.max(right.inc, right.exc);
        return sumPair;
    }

    // To print nodes that are k distance from root
    public static void printAtLevelK(Node root, int k) {

        //base case
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        //rec case
        printAtLevelK(root.left, k - 1);
        printAtLevelK(root.right, k - 1);
    }

    // To print nodes that are k distance from target in a Binary tree
    public static int printNodesAtDistanceK(Node root, int target, int k) {
        // base case
        if (root == null) {
            return -1;
        }

        // reach the target node
        if (root.data == target) {
            printAtLevelK(root, k);
            return 0;
        }

        int DL = printNodesAtDistanceK(root.left, target, k);
        if (DL != -1) {

            // 2 cases
            // print the current node
            if (DL + 1 == k) {
                System.out.println(root.data);
            } else {
                printAtLevelK(root.right, k - 2 - DL);
            }
            return 1 + DL;
        }

        int DR = printNodesAtDistanceK(root.right, target, k);
        if (DR != -1) {
            // 2 cases
            // print the current node
            if (DR + 1 == k) {
                System.out.println(root.data);
            } else {
                printAtLevelK(root.left, k - 2 - DR);
            }
            return 1 + DR;
        }
        return -1;
    }

    public static void verticalOrderPrint(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int d = 0;
        traverseTree(root, d, map);

        for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            int key = m.getKey();
            List<Integer> list = m.getValue();
            for (Integer l : list) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    // Helper method
    private static void traverseTree(Node node, int d, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }

        if (map.containsKey(d)) {
            map.get(d).add(node.data);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.data);
            map.put(d, list);
        }
        // traverse left then decrease the distance by 1 i.e. d-1
        traverseTree(node.left, d - 1, map);

        // traverse left then increase the distance by 1 i.e. d+1
        traverseTree(node.right, d + 1, map);
    }

    public static int minDepth(Node root) {
        Node temp = root;
        if (temp != null) {
            int hleft = height(root.left);
            int hright = height(root.right);
            return 1 + Math.min(hleft, hright);
        }
        return -1;
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(Node left, Node right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;

        return left.data == right.data && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }


    private static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null)
            return true;
        else if (a == null || b == null)
            return false;

        return a.data == b.data && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public static void main(String[] args) {

        // 1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1

//        Node root = buildTree();
//        printPreorder(root);
//        System.out.println();
//        printInorder(root);
//        System.out.println();
//        printPostOrder(root);
//        System.out.println();
//        levelOrder(root);


        // 1 2 3 4 5 -1 6 -1 -1 7 -1 -1 -1 -1 -1

//		Node r1 = levelorderBuild();
//		levelOrder(r1);
//		System.out.println("Height of the tree is : " + height(r1));
//		System.out.println("Diameter of the tree is : " + diameter(r1));
//		HDPair pair = optDiameter(r1);
//        System.out.println("Height of the tree is : " + pair.height + " & diameter of tree is : " + pair.diameter);

        // 1 2 4 -1 -1 5 7 -1 -1 -1 3 -1 6 -1 -1
//        ArrayList<Integer> list = new ArrayList<>();
//        printRootToLeaf(root, list);

//        levelOrder(root);
//        System.out.println("Descendant sum is: " + replaceWithDescendantSum(root));
//        levelOrder(root);

//        1 2 3 4 5 -1 6 -1 -1 7 8 -1 -1 -1 -1 9 10 -1 -1 -1 -1
//        Node r1 = levelorderBuild();
//        levelOrder(r1);
/*
        HBPair hbPair = heightBalancedTree(root);
        if (hbPair.isBalanced) {
            System.out.println("Yes, its a height Balanced tree");
        } else {
            System.out.println("Not a height Balanced tree");
        }
*/


/*        MaxSubSumPair sumPair = maximumSubSetSumTree(root);
        System.out.println("Max subset sum is: " + Math.max(sumPair.inc, sumPair.exc));*/

//        printAtLevelK(root, 2);

        // 1 2 4 -1 -1 5 7 -1 -1 8 9 -1 -1 10 -1 -1 3 -1 6 -1 -1
/*        int target = 5;
        printNodesAtDistanceK(root, target, 2);*/

        // 1 2 4 -1 -1 5 -1 -1 3 6 -1 8 -1 -1 7 -1 9 -1 -1
//        verticalOrderPrint(root);

        // 2 7 5 -1 9 -1 1 11 4 -1 -1 -1 -1 -1 -1
/*        Node r1 = levelorderBuild();
        levelOrder(r1);
        System.out.println("Minimum depth is : " + minDepth(r1));*/


        // 1 2 2 3 4 4 3 -1 -1 -1 -1 -1 -1 -1 -1
/*        Node r1 = levelorderBuild();
        levelOrder(r1);
        if (isSymmetric(r1))
            System.out.println("yes, it is a symmetric tree");
        else
            System.out.println("Not a symmetric tree");*/


/*
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);

        Node b = new Node(1);
        b.left = new Node(2);
        b.right = new Node(3);
        if (isSameTree(a, b))
            System.out.println("yes, it is a identical tree");
        else
            System.out.println("Not an identical tree");
*/

        // 1 2 3 4 5  6 7 -1 -1 -1 -1 -1 -1 -1 -1
		Node r1 = levelorderBuild();
        levelOrder(r1);
        Node invertTree = invertTree(r1);
        levelOrder(invertTree);

    }

}
