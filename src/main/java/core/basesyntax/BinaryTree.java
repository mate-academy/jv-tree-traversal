package core.basesyntax;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
        Stack<Node> nodesStack = new Stack<>();
        nodesStack.add(root);
        List<Node> nodesList = new ArrayList<>();
        while (!nodesStack.isEmpty()) {
            Node tempNode = nodesStack.pop();
            nodesList.add(0, tempNode);
            if (tempNode.getLeft() != null) {
                nodesStack.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                nodesStack.add(tempNode.getRight());
            }
        }
        return nodesList;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        Stack<Node> nodesStack = new Stack<>();
        List<Node> nodesList = new ArrayList<>();
        Node currentNode = node;
        while (currentNode != null || !nodesStack.isEmpty()) {
            if (currentNode == null) {
                Node tempNode = nodesStack.pop();
                nodesList.add(tempNode);
                currentNode = tempNode.getRight();
            } else {
                nodesStack.add(currentNode);
                currentNode = currentNode.getLeft();
            }
        }
        return nodesList;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        Stack<Node> nodesStack = new Stack<>();
        nodesStack.add(node);
        List<Node> nodesList = new ArrayList<>();
        while (!nodesStack.isEmpty()) {
            Node tempNode = nodesStack.pop();
            nodesList.add(tempNode);
            if (tempNode.getRight() != null) {
                nodesStack.add(tempNode.getRight());
            }
            if (tempNode.getLeft() != null) {
                nodesStack.add(tempNode.getLeft());
            }
        }
        return nodesList;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> nodesQueue = new ArrayDeque<>();
        nodesQueue.add(root);
        List<Node> nodesList = new ArrayList<>();
        while (!nodesQueue.isEmpty()) {
            Node tempNode = nodesQueue.remove();
            nodesList.add(tempNode);
            if (tempNode.getLeft() != null) {
                nodesQueue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                nodesQueue.add(tempNode.getRight());
            }
        }
        return nodesList;
    }
}
