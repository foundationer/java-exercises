package org.mackenzine.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeTest {

    private Tree<Integer> tree;

    @Test
    public void preOrderOfEmptyTree() {
        tree = new Tree<>();

        assertTrue(tree.preOrder().isEmpty());
    }

    @Test
    public void preOrderOfTreeWithSingleElement() {
        tree = new Tree(1);

        assertEquals(Integer.valueOf(1), tree.preOrder().get(0));
    }

    @Test
    public void preOrderOfFullyFormedTree() {
        tree = new Tree(1, new Tree(2), new Tree(3));

        assertEquals(Arrays.asList(1, 2, 3), tree.preOrder());
    }
}
