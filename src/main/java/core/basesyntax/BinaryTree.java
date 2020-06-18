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
        List<Node> postOrder = new ArrayList<>();
        postOrder(node, postOrder);
        return postOrder;
    }

    private void postOrder(Node node, List<Node> postOrder){
        if (node == null) return;
        postOrder(node.getLeft(), postOrder);
        postOrder(node.getRight(), postOrder);
        postOrder.add(node);
    }

    /* Given a binary tree, print its nodes in inorder*/
    public List<Node> getNodesInorder(Node node) {
        List<Node> inOrder = new ArrayList<>();
        inOrder(node, inOrder);
        return inOrder;
    }

    private void inOrder(Node node, List<Node> inOrder){
        if (node == null) return;
        inOrder(node.getLeft(), inOrder);
        inOrder.add(node);
        inOrder(node.getRight(), inOrder);
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesPreOrder(Node node) {
        List<Node> preOrder = new ArrayList<>();
        preOrder(node, preOrder);
        return preOrder;
    }

    private void preOrder(Node node, List<Node> preOrder){
        if (node == null) return;
        preOrder.add(node);
        preOrder(node.getLeft(), preOrder);
        preOrder(node.getRight(), preOrder);
    }

    /* Given a binary tree, print its nodes in pre order*/
    public List<Node> getNodesBreadthFirst(Node node) {
        return bfs(node);
    }

    private List<Node> bfs(Node node) {
        List<Node> queue = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        queue.add(node);
        while(queue.size() > 0){
            Node tempNode = queue.get(0);
            queue.remove(0);
            list.add(tempNode);
            if (tempNode.getLeft() != null){
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null){
                queue.add(tempNode.getRight());
            }
        }
        return list;
    }
}
