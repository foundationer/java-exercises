package org.mackenzine.collections;

public class Node<T> {

    final private T value;
    final private Node<T> previous;
    final private Node<T> next;

    public Node(final T value, final Node<T> previous, final Node<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public T value() {
        return value;
    }

    public Node<T> next() {
        return next;
    }

    public Node<T> previous() {
        return previous;
    }
}
