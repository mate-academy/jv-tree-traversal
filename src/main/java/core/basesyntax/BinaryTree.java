package core.basesyntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
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

    public List<Node> getNodesPostOrder(Node node) {
        List<Node> result = new ArrayList<>();
        getPostOrder(node, result);
        return result;
    }

    public List<Node> getNodesInorder(Node node) {
        List<Node> result = new ArrayList<>();
        getInOrder(node, result);
        return result;
    }

    public List<Node> getNodesPreOrder(Node node) {
        List<Node> result = new ArrayList<>();
        getPreOrder(node, result);
        return result;
    }

    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> result = new ArrayList<>();
        Queue<Node> resQueue = new LinkedList<>();
        resQueue.add(node);

        while (!resQueue.isEmpty()) {
            Node temporary = resQueue.poll();
            result.add(temporary);

            if (temporary.getLeft() != null) {
                resQueue.add(temporary.getLeft());
            }

            if (temporary.getRight() != null) {
                resQueue.add(temporary.getRight());
            }
        }
        return result;
    }

    private void getPostOrder(Node node, List<Node> result) {
        if (node == null) {
            return;
        }
        getPostOrder(node.getLeft(), result);
        getPostOrder(node.getRight(), result);
        result.add(node);

    }

    private void getInOrder(Node node, List<Node> result) {
        if (node == null) {
            return;
        }
        getInOrder(node.getLeft(), result);
        result.add(node);
        getInOrder(node.getRight(), result);
    }

    private void getPreOrder(Node node, List<Node> result) {
        if (node == null) {
            return;
        }
        result.add(node);
        getPreOrder(node.getLeft(), result);
        getPreOrder(node.getRight(), result);
    }
}
