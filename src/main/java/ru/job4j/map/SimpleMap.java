package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (capacity * LOAD_FACTOR <= count) {
            capacity *= 2;
            expand();
        }
        boolean result = false;
        int index = index(key);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            result = true;
            modCount++;
            count++;

        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> entry : oldTable) {
            if (entry != null) {
                int index = index(entry.key);
                table[index] = entry;
            }
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] != null && table[index].key == key) {
            value = table[index].value;
        }
        return value;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            table[index] = null;
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    private int index(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int cursor = 0;
            private int found = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return found < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[cursor] == null) {
                    cursor++;
                }
                found++;
                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
