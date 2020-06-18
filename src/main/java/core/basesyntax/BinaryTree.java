package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        List<Node> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (node == null) {
            return nodes;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            nodes.add(current);
            addNodeToStack(current.getLeft(), stack);
            addNodeToStack(current.getRight(), stack);
        }
        Collections.reverse(nodes);
        return nodes;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (node == null) {
            return nodes;
        }
        Node current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            nodes.add(current);
            current = current.getRight();
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (node == null) {
            return stack;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            nodes.add(current);
            addNodeToStack(current.getRight(), stack);
            addNodeToStack(current.getLeft(), stack);
        }
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (node == null) {
            return nodes;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            nodes.add(current);
            addNodeToQueue(current.getLeft(), queue);
            addNodeToQueue(current.getRight(), queue);
        }
        return nodes;
    }

    private void addNodeToQueue(Node node, Queue<Node> queue) {
        if (node != null) {
            queue.add(node);
        }
    }

    private void addNodeToStack(Node node, Stack<Node> stack) {
        if (node != null) {
            stack.push(node);
        }
    }
}
