package core.basesyntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    // Root of Binary Tree
    private Node root;

    private final List<Node> list = new ArrayList<>();

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
            return this.list;
        }

        getNodesPostOrder(node.getLeft());
        getNodesPostOrder(node.getRight());
        this.list.add(node);
        return this.list;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node == null) {
            return this.list;
        }

        getNodesInorder(node.getLeft());
        this.list.add(node);
        getNodesInorder(node.getRight());
        return this.list;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        if (node == null) {
            return this.list;
        }

        this.list.add(node);
        getNodesPreOrder(node.getLeft());
        getNodesPreOrder(node.getRight());

        return this.list;
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
