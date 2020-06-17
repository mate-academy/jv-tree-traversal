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
        List<Node> nodes = new ArrayList<>();
        if (node.getLeft() != null) {
            nodes.addAll(getNodesPostOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            nodes.addAll(getNodesPostOrder(node.getRight()));
        }
        nodes.add(node);
        return nodes;
    }

    public List<Node> getNodesInorder(Node node) {
        List<Node> nodes = new ArrayList<>();
        if (node.getLeft() != null) {
            nodes.addAll(getNodesInorder(node.getLeft()));
        }
        nodes.add(node);
        if (node.getRight() != null) {
            nodes.addAll(getNodesInorder(node.getRight()));
        }
        return nodes;
    }

    public List<Node> getNodesPreOrder(Node node) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        if (node.getLeft() != null) {
            nodes.addAll(getNodesPreOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            nodes.addAll(getNodesPreOrder(node.getRight()));
        }
        return nodes;
    }

    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> nodes = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            nodes.add(tempNode);
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        return nodes;
    }
}
