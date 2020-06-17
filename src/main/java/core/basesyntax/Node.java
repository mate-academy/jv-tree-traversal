package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

class Node {
    private int key;
    private Node left;
    private Node right;

    public Node(int item) {
        key = item;
        left = right = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public List<Node> getNodesInorder(Node node) {
        List<Node> result = new ArrayList<>();
        List<Node> leftNodes = new ArrayList<>();
        leftNodes.add(node);
        while (leftNodes.get(leftNodes.size()-1).getLeft() != null){
            leftNodes.add(leftNodes.get(leftNodes.size()-1).getLeft());
        }

        return result;
    }
}
