package core.basesyntax;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public List<Node> getNodesInorder(Node node) {
        List<Node> result = new ArrayList<>();
        List<Node> rootNodes = new ArrayList<>();
        rootNodes.add(node);
        int currentPosition = 0;
        while (currentPosition >= 0) {
            Node currentNode = rootNodes.get(currentPosition);
            if (currentNode.getLeft() != null && !rootNodes.contains(currentNode.getLeft())){
                rootNodes.add(currentNode.getLeft());
                currentPosition ++;
                continue;
            }
            if (!result.contains(currentNode)){
                result.add(currentNode);
                continue;
            }
            if (currentNode.getRight() != null && !rootNodes.contains(currentNode.getRight())){
                rootNodes.add(currentNode.getRight());
                currentPosition = rootNodes.indexOf(currentNode.getRight());
                continue;
            }
            currentPosition --;
        }
        return result;
    }

    public List<Node> getNodesPostOrder(Node node) {
        List<List<Node>> rows = new ArrayList<>();
        List<Node> nextRow = new ArrayList<>();
        nextRow.add(node);
        rows.add(nextRow);
        while (nextRow.size() > 0) {
            nextRow = new ArrayList<>();
            for (Node value : rows.get(rows.size() - 1)) {
                if (value.getLeft() != null) {
                    nextRow.add(value.getLeft());
                }
                if (value.getRight() != null) {
                    nextRow.add(value.getRight());
                }
            }
            rows.add(nextRow);
        }
        return IntStream.range(1, rows.size() + 1).mapToObj(i -> rows.get(rows.size() - i))
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<Node> getNodesPreOrder(Node node) {
        List<Node> result = new ArrayList<>();
        result.add(node);
        int currentNode = 0;
        while (currentNode >= 0) {
            if(result.get(currentNode).getLeft() != null
                    && !result.contains(result.get(currentNode).getLeft())){
                result.add(result.get(currentNode).getLeft());
                currentNode ++;
                continue;
            }
            if(result.get(currentNode).getRight() != null
                    && !result.contains(result.get(currentNode).getRight())){
                result.add(result.get(currentNode).getRight());
                currentNode ++;
                continue;
            }
            currentNode--;
        }
        return result;
    }

    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> nodes = new ArrayList<>();
        List<Node> currentRow = new ArrayList<>();
        currentRow.add(node);
        while (!currentRow.isEmpty()) {
            List<Node> nextRow = new ArrayList<>();
            for (Node value : currentRow) {
                if (value.getLeft() != null) {
                    nextRow.add(value.getLeft());
                }
                if (value.getRight() != null) {
                    nextRow.add(value.getRight());
                }
            }
            nodes.addAll(currentRow);
            currentRow.clear();
            currentRow.addAll(nextRow);
        }
        return nodes;
    }
}
