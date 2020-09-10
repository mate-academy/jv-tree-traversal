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
        List<Node> postOrder = new ArrayList<>();
        if (node.getLeft() != null) {
            postOrder.addAll(getNodesPostOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            postOrder.addAll(getNodesPostOrder(node.getRight()));
        }
        postOrder.add(node);
        return postOrder;
    }

    public List<Node> getNodesInorder(Node node) {
        List<Node> inOrder = new ArrayList<>();
        if (node.getLeft() != null) {
            inOrder.addAll(getNodesInorder(node.getLeft()));
        }
        inOrder.add(node);
        if (node.getRight() != null) {
            inOrder.addAll(getNodesInorder(node.getRight()));
        }
        return inOrder;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> preOrder = new ArrayList<>();
        preOrder.add(node);
        if (node.getLeft() != null) {
            preOrder.addAll(getNodesPreOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            preOrder.addAll(getNodesPreOrder(node.getRight()));
        }
        return preOrder;
    }

    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> nodeList = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            nodeList.add(tempNode);
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        return nodeList;
    }
}
