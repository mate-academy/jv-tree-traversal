package core.basesyntax;

public class Main {

    // Driver method
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new Node(1));
        tree.getRoot().setLeft(new Node(2));
        tree.getRoot().setRight(new Node(3));
        tree.getRoot().getLeft().setLeft(new Node(4));
        tree.getRoot().getLeft().setRight(new Node(5));

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(tree.getRoot());

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.getRoot());

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(tree.getRoot());
    }
}
