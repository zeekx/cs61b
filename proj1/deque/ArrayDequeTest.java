package deque;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    ArrayDeque<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayDeque<>();
    }

    @Test
    public void addFirstWhenEmpty() {
        list.addFirst(2);
        Integer firstItem = list.get(0);
        assertTrue(firstItem.equals(2));
    }
    @Test
    public void addFirst() {
        list.addFirst(2);
        assertTrue(list.get(0).equals(2));

        list.addFirst(1);
        assertTrue(list.get(0).equals(1));

        list.addFirst(0);
        assertTrue(list.get(0).equals(0));
    }
    @Test
    public void addLast() {
        list.addLast(1);
        assertTrue(list.get(list.size()-1).equals(1));
    }

    @Test
    public void getLast() {
        
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        assertTrue(list.get(list.size()-1).equals(99));
    }

    @Test
    public void resize3_4__6_7() {
        for (int i = 0; i < 7; i++) {
            list.addLast(i);
        }

        //cause resize
        list.addLast(7);

        for (int i = 0; i < 8; i++) {
            assertEquals(list.get(i).intValue(), i);
        }
    }
    @Test
    public void getLastBeyond() {
        
        for (int i = 0; i < 101; i++) {
            list.addLast(i);
        }
        assertTrue(list.get(list.size()-1).equals(100));
    }

    @Test
    public void removeLast() {
        list.addLast(1);
        list.addLast(2);
        list.removeLast();
        assertTrue(list.get(list.size()-1).equals(1));
    }

    @Test
    public void removeLast101() {
        
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        list.addLast(100);
        list.removeLast(); //remove the last '100'
        assertTrue(list.get(list.size()-1).equals(99));
    }

    @Test
    public void testMegaInsert() {
        
        int N = 100000;
        for (int i = 0; i < N; i += 1) {
            list.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            list.addLast(list.get(i));
        }
    }
    
    
    //======from cs61b

        @Test
        /** Adds a few things to the list, checking isEmpty() and size() are correct,
         * finally printing the results.
         * && is the "and" operation. */
        public void addIsEmptySizeTest() {

            ArrayDeque<String> lld1 = new ArrayDeque<String>();

            assertTrue("A newly initialized Deque should be empty", lld1.isEmpty());
            lld1.addFirst("front");

            // The && operator is the same as "and" in Python.
            // It's a binary operator that returns true if both arguments true, and false otherwise.
            assertEquals(1, lld1.size());
            assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

            lld1.addLast("middle");
            assertEquals(2, lld1.size());

            lld1.addLast("back");
            assertEquals(3, lld1.size());
        }

        @Test
        public void equals() {
            ArrayDeque<Integer> a = new ArrayDeque<>();
            ArrayDeque<Integer> b = new ArrayDeque<>();
            assertSame("a and b both empty, so they're equal", true, a.equals(b));
        }

        @Test
        public void addLastThenRemoveFirst() {
            for (int i = 0; i < 8; i++) {
                list.addLast(i);
                list.removeFirst();
            }
            assertTrue(list.isEmpty());
        }

        @Test
        public void addLastThenRemoveLast() {
            for (int i = 0; i < 8; i++) {
                list.addLast(i);
                list.removeLast();
            }
            assertTrue(list.isEmpty());
        }

        @Test
        public void addFirstThenRemoveFirst() {
            for (int i = 0; i < 8; i++) {
                list.addFirst(i);
                list.removeFirst();
            }
            assertTrue(list.isEmpty());
        }

        @Test
        public void addFirstThenRemoveLast() {
            for (int i = 0; i < 8; i++) {
                list.addFirst(i);
                list.removeLast();
            }
            assertTrue(list.isEmpty());
        }
        @Test
        public void equalsInteger() {
            ArrayDeque<Integer> a = new ArrayDeque<>();
            ArrayDeque<Integer> b = new ArrayDeque<>();
            a.addLast(1);
            a.addLast(2);

            b.addLast(1);
            b.addLast(2);
            assertSame("a and b both contains [1, 2], so they're equal", true, a.equals(b));
        }
        @Test
        public void addFirstRemoveLastCheckSize() {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            final int LEN = 8;
            for (int i = 0; i < LEN; i++) {
                queue.addFirst(i);
            }
            for (int i = 0; i < LEN; i++) {
                queue.removeLast();
            }
            for (int i = 0; i < LEN; i++) {
                queue.addFirst(i);
            }
            assertEquals(LEN, queue.size());
            assertFalse(queue.isEmpty());
        }

        @Test
        public void addFirstRemoveFirstCheckSize() {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            final int LEN = 8;
            for (int i = LEN-1; i >= 0; i--) {
                queue.addFirst(i);
            }
            for (int i = 0; i < LEN; i++) {
                assertEquals(i, queue.removeFirst().intValue());
            }
            assertTrue(queue.isEmpty());
            for (int i = 0; i < LEN; i++) {
                queue.addFirst(i);
            }
            assertEquals(8, queue.size());
            assertFalse(queue.isEmpty());
        }
        @Test
        public void equalsIntegerFalse() {
            ArrayDeque<Integer> a = new ArrayDeque<>();
            ArrayDeque<Integer> b = new ArrayDeque<>();
            a.addLast(1);
            a.addLast(2);

            b.addLast(2);
            b.addLast(3);
            String msg = "a contains [1, 2], b contains [2, 3], so they are NOT equal";
            assertNotEquals(msg, a, b);
        }

        @Test
        public void equalsString() {
            ArrayDeque<String> a = new ArrayDeque<>();
            ArrayDeque<String> b = new ArrayDeque<>();
            a.addLast("Hello");
            a.addLast("world");

            b.addLast("Hello");
            b.addLast("world");

            assertSame("a and b both contains 'hello, world', so they're equal", true, a.equals(b));
        }

        @Test
        public void getNull() {
            ArrayDeque<Integer> list = new ArrayDeque<>();
            assertEquals("Get null from a empty list", null, list.get(0));
            assertEquals("Get null from a empty list", null, list.get(1) );
        }
        @Test
        public void get() {
            ArrayDeque<Integer> ints = new ArrayDeque<>();
            ints.addLast(0);
            ints.addLast(1);
            ints.addLast(2);
            ints.addLast(3);

            assertEquals(4, ints.size());
            assertEquals(0, ints.get(0), 0);
            assertEquals(1, ints.get(1), 0);
            assertEquals(2, ints.get(2), 0);
            assertEquals(3, ints.get(3), 0);
        }
        @Test
        /** Adds an item, then removes an item, and ensures that dll is empty afterward. */
        public void addRemoveTest() {

            ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
            // should be empty
            assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

            lld1.addFirst(10);
            // should not be empty
            assertFalse("lld1 should contain 1 item", lld1.isEmpty());

            lld1.removeFirst();
            // should be empty
            assertTrue("lld1 should be empty after removal", lld1.isEmpty());

        }

        @Test
        /* Tests removing from an empty deque */
        public void removeEmptyTest() {

            ArrayDeque<Integer> lld1 = new ArrayDeque<>();
            lld1.addFirst(3);

            lld1.removeLast();
            lld1.removeFirst();
            lld1.removeLast();
            lld1.removeFirst();

            int size = lld1.size();
            String errorMsg = "  Bad size returned when removing from empty deque.\n";
            errorMsg += "  student size() returned " + size + "\n";
            errorMsg += "  actual size() returned 0\n";

            assertEquals(errorMsg, 0, size);
        }

        @Test
        /* Check if you can create ArrayDeques with different parameterized types*/
        public void multipleParamTest() {
            ArrayDeque<String>  lld1 = new ArrayDeque<String>();
            ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
            ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

            lld1.addFirst("string");
            lld2.addFirst(3.14159);
            lld3.addFirst(true);

            String s = lld1.removeFirst();
            double d = lld2.removeFirst();
            boolean b = lld3.removeFirst();
        }

        @Test
        /* check if null is return when removing from an empty ArrayDeque. */
        public void emptyNullReturnTest() {

            ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

            boolean passed1 = false;
            boolean passed2 = false;
            assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
            assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
        }

        @Test
        /* Add large number of elements to deque; check if order is correct. */
        public void bigDequeTest() {

            ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
            for (int i = 0; i < 1000000; i++) {
                lld1.addLast(i);
            }

            for (double i = 0; i < 500000; i++) {
                assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
            }

            for (double i = 999999; i > 500000; i--) {
                assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
            }
        }
    
}