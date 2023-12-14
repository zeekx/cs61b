package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import student.StudentArrayDeque;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class TestArrayDequeEC {
    private static final int ITEM_COUNT = 10;

    private PrintStream oldPrintStream;
    @Before
    public void setUp() throws Exception {
        this.oldPrintStream = System.out;
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(this.oldPrintStream);
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeEC.class);
    }

    private OutputStream setUpPrintStreamRedirect() {
        //redirect print stream to a string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        return baos;
    }

    private String printStreamToString(OutputStream outputStream) {
        return outputStream.toString();
    }

    private void resetPrintStream() {
        System.setOut(this.oldPrintStream);
    }

    @Test
    public void addRemove() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();

        StringBuilder stringBuilder = new StringBuilder();
        Integer i = 0;
        while (true) {
            boolean addOperation = StdRandom.uniform() < 0.5;
            if (addOperation) {
                boolean addAtFirst = StdRandom.uniform() < 0.5;
                if (addAtFirst) {
                    sad1.addFirst(i);
                    sad2.addFirst(i);
                    stringBuilder.append("addFirst(");
                } else {
                    sad1.addLast(i);
                    sad2.addLast(i);
                    stringBuilder.append("addLast(");
                }
                stringBuilder.append(i);
                stringBuilder.append(")\n");
            } else {
                boolean removeTheFirst = StdRandom.uniform() < 0.5;
                if (removeTheFirst) {
                    Integer int1 = sad1.removeFirst();
                    Integer int2 = sad2.removeFirst();
                    stringBuilder.append("removeFirst()\n");

                    assertEquals(stringBuilder.toString(), int1, int2);
                } else {
                    Integer int1 = sad1.removeLast();
                    Integer int2 = sad2.removeLast();
                    stringBuilder.append("removeLast()\n");
                    assertEquals(stringBuilder.toString(), int1, int2);
                }
            }

            OutputStream outputStream1 = this.setUpPrintStreamRedirect();
            sad1.printDeque();
            String output1 = this.printStreamToString(outputStream1);

            OutputStream outputStream2 = this.setUpPrintStreamRedirect();
            sad2.printDeque();
            String output2 = this.printStreamToString(outputStream2);

            assertEquals(stringBuilder.toString(), output1, output2);
        }
    }

}
