package testing;

public class Sort {
    public static void sort(String[] strs) {
        // Find the smallest item in the range
        // move it to the front of the range
        // Selection sort the rest of the range(using recursion?)
        sort(strs, 0);
    }

    private static void sort(String[] strs, int start) {
        if (start == strs.length) {
            return;
        }
        int smallestIndex = findSmallest(strs, start);
        swap(strs, start, smallestIndex);
        sort(strs, start + 1);
    }
    public static void  swap(String[] strs, int a, int b) {
        String temp = strs[a];
        strs[a] = strs[b];
        strs[b] = temp;
    }
    public static int findSmallest(String[] strs, int start) {
        int smallestIndex = start;
        for (int i = start; i < strs.length; i++) {
            if (strs[i].compareTo(strs[smallestIndex]) < 0) { //"a".compareTo("b"); // returns a negative number, here -1
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
