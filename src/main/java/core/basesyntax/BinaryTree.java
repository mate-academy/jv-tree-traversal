package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Node> result = new ArrayList<>();
        if (node.getLeft() != null) {
            result.addAll(getNodesPostOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            result.addAll(getNodesPostOrder(node.getRight()));
        }
        result.add(node);
        return result;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> result = new ArrayList<>();
        if (node.getLeft() != null) {
            result.addAll(getNodesInorder(node.getLeft()));
        }
        result.add(node);
        if (node.getRight() != null) {
            result.addAll(getNodesInorder(node.getRight()));
        }
        return result;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> result = new ArrayList<>();
        result.add(node);
        if (node.getLeft() != null) {
            result.addAll(getNodesPreOrder(node.getLeft()));
        }
        if (node.getRight() != null) {
            result.addAll(getNodesPreOrder(node.getRight()));
        }
        return result;
    }

    /* Given a binary tree, print its nodes in breadth order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        return getNodesPreOrder(node).stream()
                .collect(Collectors.groupingBy(Node::getKey))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .map(value -> value.get(0))
                .collect(Collectors.toList());
    }
}
