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
        List<Node> postOrder = new ArrayList<>();
        getPostOrder(postOrder, node);
        return postOrder;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> inOrder = new ArrayList<>();
        getInOrder(inOrder, node);
        return inOrder;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> preOrder = new ArrayList<>();
        getPreOrder(preOrder, node);
        return preOrder;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> breadthFirst = new ArrayList<>();
        queue.add(node);
        while (queue.peek() != null) {
            Node temp = queue.poll();
            breadthFirst.add(temp);
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return breadthFirst;
    }

    private void getPostOrder(List<Node> postOrder, Node node) {
        if (node == null) {
            return;
        }
        getPostOrder(postOrder, node.getLeft());
        getPostOrder(postOrder, node.getRight());
        postOrder.add(node);
    }

    private void getInOrder(List<Node> inOrder, Node node) {
        if (node == null) {
            return;
        }
        getInOrder(inOrder, node.getLeft());
        inOrder.add(node);
        getInOrder(inOrder, node.getRight());
    }

    private void getPreOrder(List<Node> preOrder, Node node) {
        if (node == null) {
            return;
        }
        preOrder.add(node);
        getPreOrder(preOrder, node.getLeft());
        getPreOrder(preOrder, node.getRight());
    }
}
