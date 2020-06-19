package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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

    /* Given a binary tree, print its nodes according to the 
      "bottom-up" post order traversal. */
    public List<Node> getNodesPostOrder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Node> nodes = new ArrayList<>();
        nodes.addAll(getNodesPostOrder(node.getLeft()));
        nodes.addAll(getNodesPostOrder(node.getRight()));
        nodes.add(node);
        return nodes;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Node> nodes = new ArrayList<>();
        nodes.addAll(getNodesInorder(node.getLeft()));
        nodes.add(node);
        nodes.addAll(getNodesInorder(node.getRight()));
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.addAll(getNodesPreOrder(node.getLeft()));
        nodes.addAll(getNodesPreOrder(node.getRight()));
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
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
