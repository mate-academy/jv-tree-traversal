package core.basesyntax;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
        List<Node> list = new ArrayList<>();
        postOrder(list, node);
        return list;
    }

    private void postOrder(List list, Node node) {
        if (node == null) {
            return;
        }
        postOrder(list, node.getLeft());
        postOrder(list, node.getRight());
        list.add(node);
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> list = new ArrayList<>();
        inOrder(list, node);
        return list;
    }

    private void inOrder(List list, Node node) {
        if (node == null) {
            return;
        }
        inOrder(list, node.getLeft());
        list.add(node);
        inOrder(list, node.getRight());
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> list = new ArrayList<>();
        preOrder(list, node);
        return list;
    }

    private void preOrder(List list, Node node) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(list, node.getLeft());
        preOrder(list, node.getRight());
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
