package org.mackenzine.collections;

import com.google.common.primitives.UnsignedInteger;

import java.util.Optional;

public class Pile<T> {

    private Node<T> top;
    private UnsignedInteger size;

    public Pile() {
        top = null;
        size = UnsignedInteger.ZERO;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Optional<T> push(T value) {
        Node<T> previous = top;
        top = new Node(value, previous, null);
        size = size.plus(UnsignedInteger.ONE);
        return getValue(previous);
    }

    public Optional<T> pop() {
        Node<T> result = top;
        if (top != null) {
            top = top.previous();
            size = size.minus(UnsignedInteger.ONE);
        }
        else
            throw new PileException("Attempt to pop element from empty pile!");
        return getValue(result);
    }

    public Optional<T> top() {
        return getValue(top);
    }

    private Optional<T> getValue(Node<T> previous) {
        return Optional.ofNullable(previous)
                .map(Node::value);
    }

    public UnsignedInteger size() {
        return size;
    }
}
