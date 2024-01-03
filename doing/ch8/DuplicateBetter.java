package ch8;

public class DuplicateBetter {
    //Better Duplicate: compare only neighbors
    public static boolean dup(int[] A) {
        for (int i = 0; i < A.length - 1; i += 1) {
            if (A[i] == A[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int size = 1000;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }
        int[] sortedArray = DummyData.makeSortedArray(size);
        System.out.println(dup(sortedArray));

        int len = 3;
        for (int i = 0; i < len-1; i++) {
            System.out.println("+");
        }
    }
}
