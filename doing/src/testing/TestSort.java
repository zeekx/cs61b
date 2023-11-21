package testing;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestSort {
//    public void main(String[] args) {
//        testFindSmallestA();
//        testFindSmallestB();
//        testSwap();
//        testSort();
//    }

    @org.junit.Test
    public void testSortA() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);
        org.junit.Assert.assertArrayEquals(input, expected);
    }

    /**
     * Test the Sort.findSamllest method.
     */
    @org.junit.Test
    public void testFindSmallestA() {
        String[] input = {"i", "have", "an", "egg"};
        int start = 0;
        int expected = 2;

        int get = Sort.findSmallest(input, start);
        org.junit.Assert.assertEquals(expected, get);
    }

    @org.junit.Test
    public void testFindSmallestB() {
        String[] input = {"i", "have", "an", "egg"};
        int start = 3;
        int expected = 3;

        int get = Sort.findSmallest(input, start);
        org.junit.Assert.assertEquals(expected, get);
    }
    @org.junit.Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);
    }
}