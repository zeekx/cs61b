package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;

    private int front;
    private int last;
    private final float RESIZE_FACTOR = 1.618F;
    private final double LOWEST_RATIO = 0.25;
    private final int INIT_CAPACITY = 8;
    private final int CHECK_RATIO_CAPACITY = 16;
    /** Creates an empty list. */
    public ArrayDeque() {
        this.size = 0;
        this.front = 0;
        this.last = 0;
        this.items = (T[])(new Object[INIT_CAPACITY]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArrayDeque)) {
            return false;
        }

        ArrayDeque<?> deque = (ArrayDeque<?>) obj;
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
    public void addFirst(T x) {
        if (isFull()) {
            resize((int)(this.items.length * RESIZE_FACTOR));
        }
        final int length = this.items.length;
        this.front = isEmpty() ? this.front : (this.front - 1 + length) % length;
        items[this.front] = x;
        size += 1;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (isFull()) { // full
            resize((int) (this.size * RESIZE_FACTOR));
        }
        this.last = isEmpty() ? this.last : (this.last + 1) % this.items.length;
        items[this.last] = x;
        size += 1;
    }
    public boolean isEmpty() {
        return this.size() == 0;
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
    public T getLast() {
        return items[this.last];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[(this.front + i) % this.items.length];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }

        T x = get(0);
        size -= 1;
        items[this.front] = null;

        this.front = isEmpty() ? this.front : (this.front + 1 + this.items.length) % this.items.length;
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
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }

        T x = getLast();
        size -= 1;
        items[this.last] = null;

        this.last = isEmpty() ? this.last : (this.last - 1 + this.items.length) % this.items.length;
        if (shouldShrink()) {
            resize((int)(this.size() * RESIZE_FACTOR));
        }
        return x;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        list.addLast(100);
        list.addLast(101);
    }
}