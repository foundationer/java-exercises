package org.mackenzine.collections;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equal(value, node.value) &&
                Objects.equal(previous, node.previous) &&
                Objects.equal(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value, previous, next);
    }
}
