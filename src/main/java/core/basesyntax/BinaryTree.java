package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

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
        List<Node> nodeList = new ArrayList<>();
        return getNodesPostOrderHelperRecursiveMethod(nodeList, node);
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> nodeList = new ArrayList<>();
        return getNodesInorderHelperRecursiveMethod(nodeList, node);
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> nodeList = new ArrayList<>();
        return getNodesPreOrderHelperRecursiveMethod(nodeList, node);
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> nodeList = new ArrayList<>();
        int height = getHeight(node);
        for (int i = 0; i <= height; i++) {
            nodeList = getNodesBreadthFirstHelperRecursiveMethod(nodeList, root, i);
        }
        return nodeList;
    }

    private List<Node> getNodesPostOrderHelperRecursiveMethod(List<Node> nodeList, Node node) {
        if (node == null) {
            return nodeList;
        }
        nodeList = getNodesPostOrderHelperRecursiveMethod(nodeList, node.getLeft());
        nodeList = getNodesPostOrderHelperRecursiveMethod(nodeList, node.getRight());
        nodeList.add(node);
        return nodeList;
    }

    private List<Node> getNodesInorderHelperRecursiveMethod(List<Node> nodeList, Node node) {
        if (node == null) {
            return nodeList;
        }
        nodeList = getNodesInorderHelperRecursiveMethod(nodeList, node.getLeft());
        nodeList.add(node);
        nodeList = getNodesInorderHelperRecursiveMethod(nodeList, node.getRight());
        return nodeList;
    }

    private List<Node> getNodesPreOrderHelperRecursiveMethod(List<Node> nodeList, Node node) {
        if (node == null) {
            return nodeList;
        }
        nodeList.add(node);
        nodeList = getNodesPreOrderHelperRecursiveMethod(nodeList, node.getLeft());
        nodeList = getNodesPreOrderHelperRecursiveMethod(nodeList, node.getRight());
        return nodeList;
    }

    private List<Node> getNodesBreadthFirstHelperRecursiveMethod(
            List<Node> nodeList, Node node, int level) {
        if (node == null) {
            return nodeList;
        }
        if (level == 1) {
            nodeList.add(node);
        } else if (level > 1) {
            getNodesBreadthFirstHelperRecursiveMethod(nodeList, node.getLeft(), level - 1);
            getNodesBreadthFirstHelperRecursiveMethod(nodeList, node.getRight(), level - 1);
        }
        return nodeList;
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }
}
