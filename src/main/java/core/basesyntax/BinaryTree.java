package core.basesyntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    private List<Node> list;

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
        list = new ArrayList<>();
        return recursivePostOrder(node);
    }

    public List<Node> getNodesInorder(Node node) {
        list = new ArrayList<>();
        return recursiveInorder(node);
    }

    public List<Node> getNodesPreOrder(Node node) {
        list = new ArrayList<>();
        return recursivePreOrder(node);
    }

    public List<Node> getNodesBreadthFirst(Node root) {
        list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0) {
                break;
            }
            while (nodeCount > 0) {
                Node node = q.peek();
                q.remove();
                list.add(node);
                if (node.getLeft() != null) {
                    q.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    q.add(node.getRight());
                }
                nodeCount--;
            }
        }
        return list;
    }

    private List<Node> recursivePreOrder(Node node) {
        if (node == null) {
            return null;
        }
        list.add(node);
        recursivePreOrder(node.getLeft());
        recursivePreOrder(node.getRight());
        return list;
    }

    private List<Node> recursiveInorder(Node node) {
        if (node == null) {
            return null;
        }
        recursiveInorder(node.getLeft());
        list.add(node);
        recursiveInorder(node.getRight());
        return list;
    }

    private List<Node> recursivePostOrder(Node node) {
        if (node == null) {
            return null;
        }
        recursivePostOrder(node.getLeft());
        recursivePostOrder(node.getRight());
        list.add(node);
        return list;
    }
}
