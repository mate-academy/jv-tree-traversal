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
        List<Node> list = new ArrayList<>();
        return recursivePostOrder(node, list);
    }

    public List<Node> getNodesInorder(Node node) {
        List<Node> list = new ArrayList<>();
        return recursiveInorder(node, list);
    }

    public List<Node> getNodesPreOrder(Node node) {
        List<Node> list = new ArrayList<>();
        return recursivePreOrder(node, list);
    }

    public List<Node> getNodesBreadthFirst(Node root) {
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() > 0) {
            Node node = queue.poll();
            list.add(node);
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;
    }

    private List<Node> recursivePreOrder(Node node, List<Node> list) {
        if (node == null) {
            return new ArrayList<>();
        }
        list.add(node);
        recursivePreOrder(node.getLeft(), list);
        recursivePreOrder(node.getRight(), list);
        return list;
    }

    private List<Node> recursiveInorder(Node node, List<Node> list) {
        if (node == null) {
            return new ArrayList<>();
        }
        recursiveInorder(node.getLeft(), list);
        list.add(node);
        recursiveInorder(node.getRight(), list);
        return list;
    }

    private List<Node> recursivePostOrder(Node node, List<Node> list) {
        if (node == null) {
            return new ArrayList<>();
        }
        recursivePostOrder(node.getLeft(), list);
        recursivePostOrder(node.getRight(), list);
        list.add(node);
        return list;
    }
}
