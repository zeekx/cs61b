package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;

    private int front;
    private int last;
    private final float RESIZE_FACTOR = 1.618F;
    private static final double LOWEST_RATIO = 0.25;
    private static final  int INIT_CAPACITY = 8;
    private static final int CHECK_RATIO_CAPACITY = 16;
    /**
     * Creates an empty list. */
    public ArrayDeque() {
        this.size = 0;
        this.front = 1;
        this.last = 0;
        this.items = (T[])(new Object[INIT_CAPACITY]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Deque)) {
            return false;
        }

        Deque<?> deque = (Deque<?>) obj;
        if (this.size() != deque.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(deque.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isFull() {
        return size() == items.length;//(this.last + 2) % this.items.length == this.front;
    }
    @Override
    public void addFirst(T x) {
        if (isFull()) {
            resize((int)(this.items.length * RESIZE_FACTOR));
        }
        final int length = this.items.length;
        this.front = (this.front - 1 + length) % length;
        items[this.front] = x;
        size += 1;
    }
    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        if (isFull()) { // full
            resize((int) (this.size * RESIZE_FACTOR));
        }
        this.last = (this.last + 1) % this.items.length;
        items[this.last] = x;
        size += 1;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[])(new Object[newCapacity]);
        if (this.front > this.last) {
            System.arraycopy(this.items, 0, newItems, 0, this.last+1);
            final int lengthFromFrontToEnd = this.items.length - this.front;
            final int newFront = newItems.length - lengthFromFrontToEnd;
            System.arraycopy(this.items, this.front, newItems, newFront, lengthFromFrontToEnd);
            this.front = newFront;
        } else {
            //reset front at zero
            int lengthFromFrontToLast = this.last - this.front + 1;
            System.arraycopy(this.items, this.front, newItems, 0, lengthFromFrontToLast);
            this.front = 0;
            this.last = lengthFromFrontToLast - 1; // last index = length - 1;
        }
        this.items = newItems;
    }

    /** Returns the item from the back of the list. */
    private T getLast() {
        return items[this.last];
    }
    /** Gets the ith item in the list (0 is the front). */
    @Override
    public T get(int i) {
        return items[(this.front + i) % this.items.length];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < size(); i++) {
            stringBuilder.append(get(i));
            stringBuilder.append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }

        T x = get(0);
        size -= 1;
        items[this.front] = null;

        this.front = (this.front + 1 + this.items.length) % this.items.length;
        if (shouldShrink()) {
            resize((int)(this.size() * RESIZE_FACTOR));
        }
        return x;
    }

    private boolean shouldShrink() {
        return this.items.length >= CHECK_RATIO_CAPACITY
                && (double)(this.size()) / this.items.length <= LOWEST_RATIO;
    }
    /** Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }

        T x = getLast();
        size -= 1;
        items[this.last] = null;

        this.last = (this.last - 1 + this.items.length) % this.items.length;
        if (shouldShrink()) {
            resize((int)(this.size() * RESIZE_FACTOR));
        }
        return x;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            private final int length = ArrayDeque.this.items.length;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                T x = ArrayDeque.this.get(this.index);
                this.index += 1;
                return x;
            }
        };
    }
}