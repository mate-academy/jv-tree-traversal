package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.setRoot(new Node(1));
        binaryTree.getRoot().setLeft(new Node(2));
        binaryTree.getRoot().setRight(new Node(3));
        binaryTree.getRoot().getLeft().setLeft(new Node(4));
        binaryTree.getRoot().getLeft().setRight(new Node(5));
    }

    @Test
    public void getNodesPostOrder() {
        List<Integer> expected = new LinkedList<>();
        expected.add(4);
        expected.add(5);
        expected.add(2);
        expected.add(3);
        expected.add(1);

        List<Integer> actual = binaryTree.getNodesPostOrder(binaryTree.getRoot())
                .stream()
                .map(Node::getKey)
                .collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNodesInOrder() {
        List<Integer> expected = new LinkedList<>();
        expected.add(4);
        expected.add(2);
        expected.add(5);
        expected.add(1);
        expected.add(3);

        List<Integer> actual = binaryTree.getNodesInorder(binaryTree.getRoot())
                .stream()
                .map(Node::getKey)
                .collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNodesPreOrder() {
        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);

        List<Integer> actual = binaryTree.getNodesPreOrder(binaryTree.getRoot())
                .stream()
                .map(Node::getKey)
                .collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBreadthFirst() {
        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        List<Integer> actual = binaryTree.getNodesBreadthFirst(binaryTree.getRoot())
                .stream()
                .map(Node::getKey)
                .collect(Collectors.toList());
        Assert.assertEquals(expected, actual);
    }
}
