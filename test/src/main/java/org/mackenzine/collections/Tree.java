package org.mackenzine.collections;

import org.mackenzine.commons.Collections;

import java.util.*;

public class Tree<T> {

    private T root;
    private Tree<T> leftTree;
    private Tree<T> rightTree;

    public Tree() {
        this.root = null;
        this.leftTree = null;
        this.rightTree = null;
    }

    public Tree(T root) {
        this.root = root;
        this.leftTree = null;
        this.rightTree = null;
    }

    public Tree(T root, Tree<T> leftTree, Tree<T> rightTree) {
        this.root = root;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public Optional<T> root() {
        return Optional.ofNullable(root);
    }

    public Optional<Tree<T>> getLeftTree() {
        return Optional.ofNullable(leftTree);
    }

    public Optional<Tree<T>> getRightTree() {
        return Optional.ofNullable(rightTree);
    }

    public List<T> preOrder() {
        Pile<Tree<T>> pileOfTrees = new Pile<>();
        List<T> result = new ArrayList<>();
        pileOfTrees.push(this);
        while (!pileOfTrees.isEmpty()) {
            Optional<Tree<T>> top = pileOfTrees.pop();
            if(top.isPresent()) {
                Tree<T> currentTree = top.get();
                currentTree
                        .getRightTree()
                        .ifPresent(rightTree -> pileOfTrees.push(rightTree));
                currentTree
                        .getLeftTree()
                        .ifPresent(leftTree -> pileOfTrees.push(leftTree));
                currentTree
                        .root()
                        .ifPresent(value -> result.add(value));
            }
        }
        return result;
    }
}
