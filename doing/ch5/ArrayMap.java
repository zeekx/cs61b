package ch5;

import java.util.*;

/***
 * An array-based implementation of Map61B.
 ***/
public class ArrayMap<K, V> implements Map61B<K, V> {
    public static void main(String[] args) {
        String studentA = "ABC";
        String studentB = "abc";
        ArrayMap<String, Integer> M = new ArrayMap<>();
        M.put(studentA, 0);
        System.out.println(studentA + ":" + M.get(studentA));
        M.put(studentA, 99);
        System.out.println(studentA + ":" + M.get(studentA));
        System.out.println(studentB + ":" + M.get(studentB));
    }

    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /**
     * Returns the index of the key, if it exists. Otherwise returns -1.
     **/
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {

    }

    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
        } else {
            values[index] = value;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>(Arrays.asList(this.keys));
        set.remove(null);
        return set;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    public V get(K key) {
        int index = keyIndex(key);
        if (0 <= index && index < values.length) {
            return values[index];
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}