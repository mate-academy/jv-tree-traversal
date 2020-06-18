package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        if (node == null) {
            return Collections.emptyList();
        }

        List<Node> nodesList = new ArrayList<>();
        nodesList.addAll(getNodesPostOrder(node.getLeft()));
        nodesList.addAll(getNodesPostOrder(node.getRight()));
        nodesList.add(node);
        return nodesList;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Node> nodesList = new ArrayList<>();
        nodesList.addAll(getNodesInorder(node.getLeft()));
        nodesList.add(node);
        nodesList.addAll(getNodesInorder(node.getRight()));
        return nodesList;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Node> nodesList = new ArrayList<>();
        nodesList.add(node);
        nodesList.addAll(getNodesPreOrder(node.getLeft()));
        nodesList.addAll(getNodesPreOrder(node.getRight()));
        return nodesList;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> nodeQueue = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        nodeQueue.add(node);

        while (!nodeQueue.isEmpty()) {
            Node pop = nodeQueue.poll();
            list.add(pop);

            if (pop.getLeft() != null) {
                nodeQueue.add(pop.getLeft());
            }

            if (pop.getRight() != null) {
                nodeQueue.add(pop.getRight());
            }
        }

        return list;
    }
}
