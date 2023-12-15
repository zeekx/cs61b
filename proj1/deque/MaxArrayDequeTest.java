package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;


public class MaxArrayDequeTest {
    static class Dog implements Comparable<Dog> {
        public int getAge() {
            return age;
        }

        private final int age;
        public Dog(int age) {
            this.age = age;
        }

        private static class AgeComparator implements Comparator<Dog> {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.age - o2.age;
            }
        }

        public static Comparator<Dog> getAgeComparator() {
            return new AgeComparator();
        }
        @Override
        public int compareTo(Dog o) {
            if (o == null) {
                return 1;
            }
            return this.age - o.age;
        }
    }
    @Test
    public void maxNull() {
        MaxArrayDeque<Integer> queue = new MaxArrayDeque<>(null);
        assertNull(queue.max());
    }

    @Test
    public void maxNonnull() {
        MaxArrayDeque<Dog> queue = new MaxArrayDeque<>(Dog.getAgeComparator());
        Dog[] dogs = {new Dog(1), new Dog(2)};
        queue.addLast(dogs[0]);
        queue.addLast(dogs[1]);
        assertNotEquals(null, queue.max());
    }
    @Test
    public void testMax() {
        Dog[] dogs = {new Dog(1), new Dog(2)};
        MaxArrayDeque<Dog> queue = new MaxArrayDeque<>(Dog.getAgeComparator());
        queue.addLast(dogs[0]);
        queue.addLast(dogs[1]);
        assertEquals(2, queue.max().getAge());
    }

    @Test
    public void testMaxSameAgeReversed() {
        Dog[] dogs = {new Dog(1), new Dog(2)};
        MaxArrayDeque<Dog> queue = new MaxArrayDeque<>(Dog.getAgeComparator());
        queue.addLast(dogs[1]);
        queue.addLast(dogs[0]);
        assertEquals(2, queue.max().getAge());
    }
    @Test
    public void testMaxSameAge() {
        Dog[] dogs = {new Dog(2), new Dog(2)};
        MaxArrayDeque<Dog> queue = new MaxArrayDeque<>(Dog.getAgeComparator());
        queue.addLast(dogs[0]);
        queue.addLast(dogs[1]);
        assertEquals(2, queue.max().getAge());
    }



    @Test
    public void testMaxMultiDogs() {
        Dog[] dogs = {new Dog(2), new Dog(2), new Dog(0), new Dog(5), new Dog(7)};
        MaxArrayDeque<Dog> queue = new MaxArrayDeque<>(Dog.getAgeComparator());
        for (Dog dog : dogs) {
            queue.addLast(dog);
        }
        assertEquals(7, queue.max().getAge());
    }
}


