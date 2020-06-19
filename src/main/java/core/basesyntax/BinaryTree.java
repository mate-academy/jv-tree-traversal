package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;
    private List<Node> inOrder = new ArrayList<>();
    private List<Node> postOrder = new ArrayList<>();
    private List<Node> preOrder = new ArrayList<>();

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
        if (node == null) {
            return postOrder;
        }
        getNodesPostOrder(node.getLeft());
        getNodesPostOrder(node.getRight());
        postOrder.add(node);
        return postOrder;
    }

    public List<Node> getNodesInorder(Node node) {
        if (node == null) {
            return inOrder;
        }
        getNodesInorder(node.getLeft());
        inOrder.add(node);
        getNodesInorder(node.getRight());
        return inOrder;
    }

    public List<Node> getNodesPreOrder(Node node) {
        if (node == null) {
            return preOrder;
        }
        preOrder.add(node);
        getNodesPreOrder(node.getLeft());
        getNodesPreOrder(node.getRight());
        return preOrder;
    }

    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> queue = new ArrayList<>();
        List<Node> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.get(0);
            queue.remove(0);
            result.add(tempNode);
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        return result;
    }
}
