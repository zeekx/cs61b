package ch9;

import org.junit.Before;

import static org.junit.Assert.*;

public class QuickFindDSTest extends DisjointSetsTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        DisjointSetsTest.N = 100;
        super.ds = new QuickFindDS(DisjointSetsTest.N);
    }
}