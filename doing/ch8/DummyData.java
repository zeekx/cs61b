package ch8;

public class DummyData {
        public static int[] makeSortedArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }
            return array;
        }
}
