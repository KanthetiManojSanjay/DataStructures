package binaryTree.bt;

import static binaryTree.bt.BinaryTree.levelOrderBuild;
import static binaryTree.bt.BinaryTree.levelorderPrint;

/**
 * @author kansanja on 09/03/24.
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        // Input -> 1 2 4 -1 -1 -1 3 5 -1 -1 6 -1 -1
        //BinaryTree binaryTree = new BinaryTree();
        //binaryTree.display();

        Node root = levelOrderBuild();
        levelorderPrint(root);
    }
}
