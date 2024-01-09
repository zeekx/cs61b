package ch6;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertTrue;

public class ArraySet<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new It();
    }

    private class It implements  Iterator<T> {
        private int wizPos;
        @Override
        public boolean hasNext() {
            return wizPos < ArraySet.this.size();
        }

        @Override
        public T next() {
            T x = ArraySet.this.items[wizPos++];
            return x;
        }
    }
    private T[] items;
    private int _size;
    public ArraySet() {
        this.items = (T[]) new Object[100];
        this._size = 0;
    }

    public static <E> ArraySet<E> of(E... stuff) {
        ArraySet<E> arraySet = new ArraySet<>();
        for (E e : stuff) {
            arraySet.add(e);
        }
        return arraySet;
    }
    @Override
    public String toString() {
        ArrayList<String> elementsAsStrings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("{");
        for (T item : this) {
            elementsAsStrings.add(item.toString());
        }
        stringBuilder.append(String.join(",", elementsAsStrings));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        boolean c = false;
        for (int i = 0; i < size(); i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Can't add null");
        }
        if (!contains(x)) {
            items[_size++] = x;
        }
        return;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        ArraySet<T> another = (ArraySet<T>) other;
        if (this.size() != another.size()) {
            return false;
        }
        for (T item: this) {
            if (!another.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return _size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        System.out.println("Print by foreach");
        for (String str: s) {
            System.out.println(str);
        }
        System.out.println(s);
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
