package core.basesyntax;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    // Root of Binary Tree
    private Node root;
    private List<Node> nodes;

    public BinaryTree() {
        root = null;
        nodes = new ArrayList<>();
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
        if (node != null) {
            getNodesPostOrder(node.getLeft());
            getNodesPostOrder(node.getRight());
            nodes.add(node);
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node != null) {
            getNodesInorder(node.getLeft());
            nodes.add(node);
            getNodesInorder(node.getRight());
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        if (node != null) {
            nodes.add(node);
            getNodesPreOrder(node.getLeft());
            getNodesPreOrder(node.getRight());
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();

        queue.add(node);
        while (queue.size() > 0) {
            Node temp = queue.poll();
            list.add(temp);
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return list;
    }
}
