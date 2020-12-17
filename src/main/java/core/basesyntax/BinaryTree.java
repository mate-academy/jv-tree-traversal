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
        if (node == null) {
            return new ArrayList<>();
        }
        List<Node> list = new ArrayList<>();
        list.addAll(getNodesPostOrder(node.getLeft()));
        list.addAll(getNodesPostOrder(node.getRight()));
        list.add(node);
        return list;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Node> list = new ArrayList<>();
        list.addAll(getNodesInorder(node.getLeft()));
        list.add(node);
        list.addAll(getNodesInorder(node.getRight()));
        return list;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Node> list = new ArrayList<>();
        list.add(node);
        list.addAll(getNodesPreOrder(node.getLeft()));
        list.addAll(getNodesPreOrder(node.getRight()));
        return list;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Node> list = new ArrayList<>();
        if (node == root) {
            list.add(node);
        }
        if (node.getLeft() != null) {
            list.add(node.getLeft());
        }
        if (node.getRight() != null) {
            list.add(node.getRight());
        }
        if (node.getLeft() != null) {
            list.addAll(getNodesBreadthFirst(node.getLeft()));
        }
        if (node.getRight() != null) {
            list.addAll(getNodesBreadthFirst(node.getRight()));
        }
        return list;
    }
}
