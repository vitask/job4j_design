package ru.job4j.collection;

import java.util.*;

public class ForwardLinked<T> implements Iterable<T> {

    private int size;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        Node<T> last = head;
        Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void addFirst(T value) {
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            head = new Node<>(value, head);
        }
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T prevValue = head.value;
        Node<T> temp = head.next;
        head.next = null;
        head.value = null;
        head = temp;
        return prevValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private final int expectedModCount = modCount;
            private Node<T> itElement = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return itElement != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> result = itElement;
                itElement = itElement.next;
                return result.value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}