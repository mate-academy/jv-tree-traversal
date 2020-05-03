package core.basesyntax;

import java.util.ArrayList;
import java.util.Collections;
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
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> nodes = new ArrayList<>(getNodesPostOrder(node.getLeft()));
        nodes.addAll(getNodesPostOrder(node.getRight()));
        nodes.add(node);
        return nodes;
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> nodes = new ArrayList<>(getNodesInorder(node.getLeft()));
        nodes.add(node);
        nodes.addAll(getNodesInorder(node.getRight()));
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.addAll(getNodesPreOrder(node.getLeft()));
        nodes.addAll(getNodesPreOrder(node.getRight()));
        return nodes;
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> resultList = new ArrayList<>();
        resultList.add(node);
        inspectNextLevel(resultList, resultList);
        return resultList;
    }

    private List<Node> inspectNextLevel(List<Node> nodesOnPrevLevelList, List<Node> resultList) {
        if (nodesOnPrevLevelList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Node> nodesOnThisLevelList = new ArrayList<>();
        for (Node node : nodesOnPrevLevelList) {
            if (node.getLeft() != null) {
                nodesOnThisLevelList.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodesOnThisLevelList.add(node.getRight());
            }
        }
        resultList.addAll(nodesOnThisLevelList);
        return inspectNextLevel(nodesOnThisLevelList, resultList);
    }
}
