package ru.job4j.map;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int bucket = getIndex(key);
        boolean rls = table[bucket] == null;
        if (rls) {
            MapEntry<K, V> newTable = new MapEntry<>(key, value);
            table[bucket] = newTable;
            modCount++;
            count++;
        }
        return rls;
    }
    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }
    private int indexFor(int hash) {
        return hash % capacity;
    }

    private int getIndex(K hc) {
        return indexFor(hash(Objects.hashCode(hc)));
    }
    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> keySet : table) {
            if (keySet != null) {
                K currentKey = keySet.key;
                int index = getIndex(currentKey);
                newTable[index] = keySet;
            }
        }
        table = newTable;
    }
    @Override
    public V get(K key) {
        int index = getIndex(key);
        return (table[index] != null
                && (hash(Objects.hashCode(table[index].key)) == hash(Objects.hashCode(key)))
                && Objects.equals(table[index].key, key)) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = 0;
        if (key != null) {
            index = getIndex(key);
        }
        if (table[index] != null
                && (hash(Objects.hashCode(table[index].key)) == hash(Objects.hashCode(key)))
                && Objects.equals(table[index].key, key)) {
            table[index] = null;
            count--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int nextElement = 0;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (table.length != nextElement && table[nextElement] == null) {
                    nextElement++;
                }
                return nextElement < table.length;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[nextElement++].key;
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