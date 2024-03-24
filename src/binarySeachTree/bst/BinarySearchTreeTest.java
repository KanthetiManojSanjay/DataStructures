package binarySeachTree.bst;

/**
 * @author kansanja on 09/03/24.
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst= new BinarySearchTree();
        bst.display();

        bst.removeKey(14);
        bst.display();
        System.out.println(bst.search(4));
        System.out.println(bst.search(5));
    }
}
