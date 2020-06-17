package core.basesyntax;

import java.util.ArrayList;
import java.util.Collection;
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
            if (currentNode.getLeft() != null && !rootNodes.contains(currentNode.getLeft())) {
                rootNodes.add(currentNode.getLeft());
                currentPosition++;
                continue;
            }
            if (!result.contains(currentNode)) {
                result.add(currentNode);
            }
            if (currentNode.getRight() != null && !rootNodes.contains(currentNode.getRight())) {
                rootNodes.add(currentNode.getRight());
                currentPosition = rootNodes.indexOf(currentNode.getRight());
                continue;
            }
            currentPosition--;
        }
        return result;
    }

    public List<Node> getNodesPostOrder(Node node) {
        List<List<Node>> rows = new ArrayList<>();
        List<Node> nextRow = new ArrayList<>();
        nextRow.add(node);
        rows.add(nextRow);
        while (!nextRow.isEmpty()) {
            nextRow = new ArrayList<>();
            for (Node currentNode : rows.get(rows.size() - 1)) {
                if (currentNode.getLeft() != null) {
                    nextRow.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    nextRow.add(currentNode.getRight());
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
        int currentPosition = 0;
        while (currentPosition >= 0) {
            Node currentNode = result.get(currentPosition);
            if (currentNode.getLeft() != null
                    && !result.contains(currentNode.getLeft())) {
                result.add(currentNode.getLeft());
                currentPosition++;
                continue;
            }
            if (currentNode.getRight() != null
                    && !result.contains(currentNode.getRight())) {
                result.add(currentNode.getRight());
                currentPosition++;
                continue;
            }
            currentPosition--;
        }
        return result;
    }

    public List<Node> getNodesBreadthFirst(Node node) {
        List<Node> result = new ArrayList<>();
        List<Node> currentRow = new ArrayList<>();
        currentRow.add(node);
        while (!currentRow.isEmpty()) {
            List<Node> nextRow = new ArrayList<>();
            for (Node currentNode : currentRow) {
                if (currentNode.getLeft() != null) {
                    nextRow.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    nextRow.add(currentNode.getRight());
                }
            }
            result.addAll(currentRow);
            currentRow.clear();
            currentRow.addAll(nextRow);
        }
        return result;
    }
}
