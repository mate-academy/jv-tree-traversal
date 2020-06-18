package core.basesyntax;

import java.util.ArrayList;
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
        List<Node> resultOrder = new ArrayList<>();
        Stack<Node> nodeStackFirst = new Stack<>();
        Stack<Node> nodeStackSecond = new Stack<>();

        nodeStackFirst.push(node);
        while (!nodeStackFirst.isEmpty()) {
            Node temp = nodeStackFirst.pop();
            nodeStackSecond.push(temp);

            if (temp.getLeft() != null) {
                nodeStackFirst.push(temp.getLeft());
            }
            if (temp.getRight() != null) {
                nodeStackFirst.push(temp.getRight());
            }
        }
        while (!nodeStackSecond.isEmpty()) {
            Node temp = nodeStackSecond.pop();
            resultOrder.add(temp);
        }
        return resultOrder;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> resultOrder = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.getLeft();
            }
            current = nodeStack.pop();
            resultOrder.add(current);
            current = current.getRight();
        }
        return resultOrder;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> resultOrder = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;

        nodeStack.push(current);
        while (!nodeStack.isEmpty()) {
            current = nodeStack.peek();
            resultOrder.add(current);
            nodeStack.pop();

            if (current.getRight() != null) {
                nodeStack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                nodeStack.push(current.getLeft());
            }
        }
        return resultOrder;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> resultOrder = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();

        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.poll();
            resultOrder.add(current);

            if (current.getLeft() != null) {
                nodeQueue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                nodeQueue.add(current.getRight());
            }
        }
        return resultOrder;
    }
}
