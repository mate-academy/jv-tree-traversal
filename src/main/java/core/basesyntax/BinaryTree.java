package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

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
        List<Node> result = new ArrayList<>();
        if (node.getLeft() != null) {
            result.addAll(getNodesPostOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            result.addAll(getNodesPostOrder(node.getRight()));
        }
        result.add(node);
        return result;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> result = new ArrayList<>();
        if (node.getLeft() != null) {
            result.addAll(getNodesInorder(node.getLeft()));
        }
        result.add(node);
        if (node.getRight() != null) {
            result.addAll(getNodesInorder(node.getRight()));
        }
        return result;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> result = new ArrayList<>();
        result.add(node);
        if (node.getLeft() != null) {
            result.addAll(getNodesPreOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            result.addAll(getNodesPreOrder(node.getRight()));
        }
        return result;
    }

    /* Given a binary tree, print its nodes in breadth order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        result.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.getLeft() != null) {
                result.add(currentNode.getLeft());
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                result.add(currentNode.getRight());
                queue.add(currentNode.getRight());
            }
        }
        return result;
    }
}
