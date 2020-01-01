package core.basesyntax;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    List<Node> nodes = new ArrayList<>();
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
        if (node.getLeft() != null) {
            getNodesPostOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            getNodesPostOrder(node.getRight());
        }
        nodes.add(node);
        return nodes;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node.getLeft() != null) {
            getNodesInorder(node.getLeft());
        }
        nodes.add(node);
        if (node.getRight() != null) {
            getNodesInorder(node.getRight());
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        nodes.add(node);
        if (node.getLeft() != null) {
            getNodesPreOrder(node.getLeft());
        }
        if (node.getRight() != null) {
            getNodesPreOrder(node.getRight());
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            nodes.add(temp);
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return nodes;
    }
}
