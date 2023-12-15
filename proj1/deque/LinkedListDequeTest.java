package deque;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
    @Test

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		// System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    public void AddFirstRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(3);
        int x = lld.removeLast();
        assertEquals(3, x);
    }

    @Test
    public void AddFirstTwiceRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(3);
        lld.addFirst(4);
        int x = lld.removeLast();
        assertEquals(3, x);
    }
    @Test
    public void AddFirstTripleRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(0);
        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(4);
        Integer x = lld.removeLast();
        assertNotNull(x);

        x = lld.removeLast();
        assertNotNull(x);
    }

    @Test
    public void AddFirst012RemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(0);
        lld.addFirst(1);
        lld.addFirst(2);
        Integer x = lld.removeLast();
        assertEquals(Integer.valueOf(0), x);
    }

    @Test
    public void TestRandomAddRemoveIsEmpty() {
        java.util.LinkedList<Integer> ll = new java.util.LinkedList<>();
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        int N = 100000;
        for (int i = 0; i < N; i++) {
            assertEquals(ll.isEmpty(), lld.isEmpty());
            boolean remove = StdRandom.uniform() < 0.5;
            StringBuilder stringBuilder = new StringBuilder();
            if (!ll.isEmpty() && remove) {
                boolean removeFirst = StdRandom.uniform() < 0.5;
                Integer llv = null;
                Integer lldv = null;
                if (removeFirst) {
                    llv = ll.removeFirst();
                    lldv = lld.removeFirst();
                    // System.out.println("removeFirst() :" + llv);
                } else {
                    llv = ll.removeLast();
                    lldv = lld.removeLast();
                    // System.out.println("removeLast() :" + llv);
                }
                assertEquals(llv, lldv);
                assertNotNull(lldv);
            } else {
                boolean addFirst = StdRandom.uniform() < 0.5;
                if (addFirst) {
                    ll.addFirst(i);
                    lld.addFirst(i);
                    stringBuilder.append("addFirst(");
                } else {
                    ll.addLast(i);
                    lld.addLast(i);
                    stringBuilder.append("addLast(");
                }

                stringBuilder.append(i);
                stringBuilder.append(")");
                // System.out.println(stringBuilder.toString());

                assertEquals(ll.size(), lld.size());
            }
        }
    }
    @Test
    public void TestRandomAddFirstRemoveLastIsEmpty() {
        java.util.LinkedList<Integer> ll = new java.util.LinkedList<>();
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        int N = 10000;
        for (int i = 0; i < N; i++) {
            assertEquals(ll.isEmpty(), lld.isEmpty());
            boolean remove = StdRandom.uniform() < 0.5;
            StringBuilder stringBuilder = new StringBuilder();
            if (!ll.isEmpty() && remove) {
                Integer llv = ll.removeLast();
                Integer lldv = lld.removeLast();
                // System.out.println("removeLast() :" + llv);
                assertEquals(llv, lldv);
                assertNotNull(lldv);
            } else {
                ll.addFirst(i);
                lld.addFirst(i);

                stringBuilder.append("addFirst(");
                stringBuilder.append(i);
                stringBuilder.append(")");
                // System.out.println(stringBuilder.toString());

                assertEquals(ll.size(), lld.size());
            }
        }
    }

    @Test
    public void equals() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        LinkedListDeque<Integer> b = new LinkedListDeque<>();
        assertSame("a and b both empty, so they're equal", true, a.equals(b));
    }

    @Test
    public void equalsInteger() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        LinkedListDeque<Integer> b = new LinkedListDeque<>();
        a.addLast(1);
        a.addLast(2);

        b.addLast(1);
        b.addLast(2);
        assertSame("a and b both contains [1, 2], so they're equal", true, a.equals(b));
    }

    @Test
    public void equalsIntegerFalse() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        LinkedListDeque<Integer> b = new LinkedListDeque<>();
        a.addLast(1);
        a.addLast(2);

        b.addLast(2);
        b.addLast(3);
        String msg = "a contains [1, 2], b contains [2, 3], so they are NOT equal";
        assertNotEquals(msg, a, b);
    }

    @Test
    public void equalsString() {
        LinkedListDeque<String> a = new LinkedListDeque<>();
        LinkedListDeque<String> b = new LinkedListDeque<>();
        a.addLast("Hello");
        a.addLast("world");

        b.addLast("Hello");
        b.addLast("world");

        assertSame("a and b both contains 'hello, world', so they're equal", true, a.equals(b));
    }

    @Test
    public void getRecursiveNull() {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        assertEquals("Get null from a empty list", null, list.getRecursive(0));
        assertEquals("Get null from a empty list", null, list.getRecursive(1) );
    }
    @Test
    public void getRecursive() {
        LinkedListDeque<Integer> ints = new LinkedListDeque<>();
        ints.addLast(0);
        ints.addLast(1);
        ints.addLast(2);
        ints.addLast(3);

        assertEquals(0, (int) ints.getRecursive(0));
        assertEquals(1, (int) ints.getRecursive(1));
        assertEquals(2, (int) ints.getRecursive(2));
        assertEquals(3, (int) ints.getRecursive(3));
    }
    @Test
    public void getNull() {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        assertEquals("Get null from a empty list", null, list.get(0));
        assertEquals("Get null from a empty list", null, list.get(1) );
    }
    @Test
    public void get() {
        LinkedListDeque<Integer> ints = new LinkedListDeque<>();
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

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
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
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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

    @Test
    public void testMegaInsert() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        int N = 100000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }
}
