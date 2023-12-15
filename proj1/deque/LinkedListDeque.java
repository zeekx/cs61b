package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkedListDeque)) {
            return false;
        }

        LinkedListDeque<?> list = (LinkedListDeque<?>)obj;

        if (this.size() != list.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> next = LinkedListDeque.this.sentinel.next;
            @Override
            public boolean hasNext() {
                LinkedListDeque<T> thisList = LinkedListDeque.this;
                return thisList.sentinel != next;
            }

            @Override
            public T next() {
                Node<T> node = next;
                next = next.next;
                return node.element;
            }
        };
    }

    private static class Node<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T item) {
            this(item, null, null);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Node)) {
                return false;
            }
            Node<?> node = (Node<?>)obj;
            return this.element.equals(node.element);
        }

        public Node() {
            this.prev = null;
            this.next = null;
        }

        public Node(T e, Node<T> prev, Node<T> next) {
            this.element = e;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node<T> sentinel;

    private int size;

    public LinkedListDeque() {
        Node<T> head = new Node<T>();
        this.sentinel = head;
        Node<T> tail = head;

        head.next = tail;
        tail.prev = head;

        this.size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    @Override
    public void addFirst(T item) {
        Node<T> theNewFirst = new Node<T>(item);
        Node<T> theOldFirst = sentinel.next;
        theNewFirst.next = theOldFirst;
        theNewFirst.prev = theOldFirst.prev;
        theOldFirst.prev.next = theNewFirst;
        theOldFirst.prev = theNewFirst;

        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque
     * @param item
     */
    @Override
    public void addLast(T item) {
        Node<T> node = new Node<T>(item);
        Node<T> tail = this.sentinel.prev;
        node.next = tail.next;
        tail.next = node;

        node.prev = tail;
        this.sentinel.prev = node;
        size += 1;
    }


    private T getRecursiveHelper(Node<T> node, int index) {
        if (node == this.sentinel /* || index < 0 */) {
            return null;
        } else if (index == 0) {
            return node.element;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        if (this.isEmpty()) {
            return null;
        }
        return getRecursiveHelper(this.sentinel.next, index);
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            return null;
        }
        Node<T> p = this.sentinel.next;
        for (int i = 0; i != index; i++) {
            p = p.next;
        }
        return p.element;
    }
    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        Node<T> firstNode = this.sentinel.next;
        this.sentinel.next = firstNode.next;
        firstNode.next.prev = this.sentinel;
        return firstNode.element;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null
     * @return
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> last = this.sentinel.prev;
        Node<T> secondLast = last.prev;
        secondLast.next = last.next; //secondLast.next -> sentinel
        sentinel.prev = secondLast;

        size -= 1;
        return last.element;
    }
    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Node<T> p = this.sentinel.next; p != this.sentinel; p = p.next ) {
            stringBuilder.append(p.element);
            stringBuilder.append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public int size() {
        return this.size;
    }
}
