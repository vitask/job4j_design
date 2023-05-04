package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    private void increaseCapacity() {
        container = container.length == 0 ? (T[]) new Object[1]
                : Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            increaseCapacity();
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T value) {
        T old = get(index);
        container[index] = value;
        return old;
    }

    @Override
    public T remove(int index) {
        T old = get(index);
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                size - index - 1
        );
        container[size - 1] = null;
        size--;
        modCount++;
        return old;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }
        };
    }
}