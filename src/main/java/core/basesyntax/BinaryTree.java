package core.basesyntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        Stack<Node> nodes = new Stack<>();
        List<Node> result = new ArrayList<>();
        Node current = node;
        while (true) {
            if (current != null) {
                if (current.getRight() != null) {
                    nodes.push(current.getRight());
                }
                nodes.push(current);
                current = current.getLeft();
                continue;
            }
            if (nodes.isEmpty()) {
                break;
            }
            current = nodes.pop();
            if (current.getRight() != null && !nodes.isEmpty()
                    && current.getRight() == nodes.peek()) {
                nodes.pop();
                nodes.push(current);
                current = current.getRight();
            } else {
                result.add(current);
                current = null;
            }
        }
        return result;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> result = new ArrayList<>();
        Stack<Node> nodes = new Stack<>();
        Node current = node;
        while (!nodes.isEmpty() || current != null) {
            if (current != null) {
                nodes.add(current);
                current = current.getLeft();
            } else {
                Node tempNode = nodes.pop();
                result.add(tempNode);
                current = tempNode.getRight();
            }

        }
        return result;
    }


    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        Stack<Node> nodes = new Stack<>();
        nodes.add(node);
        List<Node> result = new ArrayList<>();
        while (!nodes.isEmpty()) {
            Node current = nodes.pop();
            result.add(current);
            if (current.getRight() != null) {
                nodes.push(current.getRight());
            }
            if (current.getLeft() != null) {
                nodes.push(current.getLeft());
            }
        }
        return result;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> result = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            result.add(tempNode);
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        return result;
    }
}
