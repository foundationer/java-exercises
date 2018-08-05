package org.mackenzine.collections;

import com.google.common.base.Objects;

import java.util.Iterator;

public class Listing<T> {

    private Node<T> head;

    public Listing<T> reverse() {
        Listing<T> reversed = new Listing<>();
        Node<T> currentNode = head;
        while(currentNode != null) {
            reversed.add(currentNode.value());
            currentNode = currentNode.next();
        }
        return reversed;
    }

    public void add(T element) {
        if(head == null) {
            head = new Node<>(element, null, null);
        } else {
            Node<T> newHead = new Node<>(element, null, head);
            head = newHead;
        }
    }

    public T getFirst() {
        return head.value();
    }

    public T getLast() {
        Node<T> currentNode = head;
        T lastValue = null;
        while (currentNode != null) {
            lastValue = currentNode.value();
            currentNode = currentNode.next();
        }
        return lastValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Listing)) return false;
        Listing<?> listing = (Listing<?>) o;
        return Objects.equal(head, listing.head);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(head);
    }
}
