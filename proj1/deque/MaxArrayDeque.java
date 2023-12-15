package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        this.comparator = c;
    }
    public T max() {
        return this.max(this.comparator);
    }
    public T max(Comparator<T> c) {
        if (c == null || isEmpty()) {
            return null;
        }
        T max = this.get(0);
        for (int i = 1; i < size(); i++) {
            if (c.compare(max, get(i)) < 0) {
                max = get(i);
            }
        }
        return max;
    }
}
