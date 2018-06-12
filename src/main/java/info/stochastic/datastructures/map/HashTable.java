package main.java.info.stochastic.datastructures.map;

import java.util.LinkedList;
import java.util.Objects;

public class HashTable<K, V> {

    class Entry<Key, Value> {
        Key key;
        Value value;

        Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    private LinkedList<Entry<K, V>>[] table;

    private int size = 0;

    @SuppressWarnings({"rawtypes","unchecked"})
    public HashTable(int capacity) {
        table = new LinkedList[tableSizeFor(capacity)];
    }

    public V put(K key, V value) {
        int hash = Objects.hashCode(key) & (table.length - 1);
        LinkedList<Entry<K, V>> list = table[hash];

        if (list == null) {
            list = new LinkedList<>();
            table[hash] = list;
        }

        for (Entry<K, V> entry: list) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        size++;
        list.add(new Entry<>(key, value));
        return null;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        int hash = Objects.hashCode(key) & (table.length - 1);
        LinkedList<Entry<K, V>> list = table[hash];

        if (list == null) {
            return null;
        }

        for (Entry entry: list) {
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
