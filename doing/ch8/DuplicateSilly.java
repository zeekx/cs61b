package ch8;

public class DuplicateSilly {

    //Silly Duplicate: compare everything
    public static boolean dup(int[] A) {
        for (int i = 0; i < A.length; i += 1) {
            for (int j = i + 1; j < A.length; j += 1) {
                if (A[i] == A[j]) {
                    return true;
                }
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
    }
}

