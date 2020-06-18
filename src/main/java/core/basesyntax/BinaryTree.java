package core.basesyntax;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
        if (node != null) {
            List<Node> nodes = new ArrayList<>();
            nodes.addAll(getNodesPostOrder(node.getLeft()));
            nodes.addAll(getNodesPostOrder(node.getRight()));
            nodes.add(node);
            return nodes;
        }
        return new ArrayList<>();
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> nodes = new ArrayList<>();
        if (node != null) {
            nodes.addAll(getNodesInorder(node.getLeft()));
            nodes.add(node);
            nodes.addAll(getNodesInorder(node.getRight()));
            return nodes;
        }
        return new ArrayList<>();
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> nodes = new ArrayList<>();
        if (node != null) {
            nodes.add(node);
            nodes.addAll(getNodesPreOrder(node.getLeft()));
            nodes.addAll(getNodesPreOrder(node.getRight()));
            return nodes;
        }
        return new ArrayList<>();
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            list.add(temp);
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return list;
    }
}
