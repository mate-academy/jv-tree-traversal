package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    // Root of Binary Tree
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /* Given a binary tree, print its nodes according to the 
      "bottom-up" post order traversal. */
    public List<Node> getNodesPostOrder(Node node) {
        System.out.println("Please provide your implementation");

        return new ArrayList<>();
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        System.out.println("Please provide your implementation");
        return new ArrayList<>();
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        System.out.println("Please provide your implementation");
        return new ArrayList<>();
    }
}
