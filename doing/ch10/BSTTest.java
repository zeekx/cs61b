package ch10;

import ch9.DisjointSetsTest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 *          dog
 *       /      \
 *     bag       flat
 *    /   \     /   \
 *  alf  cat  elf  glut
 */
public class BSTTest {
    BST<String> bst;
    @Before
    public void setUp() throws Exception {
        BST<String> bst = new BST<>("dog");
        this.bst = bst;

        bst.insert("bag");
        bst.insert("alf");
        bst.insert("cat");

        bst.insert("flat");
        bst.insert("elf");
        bst.insert("glut");
    }


    @Test
    public void checkDog() {
        assertTrue(bst.isValidate());
    }

    @Test
    public void check() {
        BST<String> bst = new BST<>("=");
        assertTrue(bst.isValidate());
    }
    @Test
    public void find() {
        String[] keys = {"alf", "bag", "cat", "flat", "glut", "elf", "dog"};
        List<String> list = Arrays.asList(keys);
        Collections.shuffle(list);
        for (String key: list) {
            assertNotNull(this.bst.find(key));
        }

        assertNull(this.bst.find("I'm not exist"));
    }

    @Test
    public void deleteDog() {
        BST<String> bst = this.bst.delete("dog");
        assertNotNull(bst);
        assertTrue(bst.isValidate());
    }

    @Test
    public void deleteAlf() {
        BST<String> alf = this.bst.find("alf");
        assertNotNull(alf);
        BST<String> deletedAlf = this.bst.delete("alf");
        assertNotNull(deletedAlf);
        BST<String> noAlf = this.bst.find("alf");
        assertNull(noAlf);
        assertTrue(bst.isValidate());
    }

    @Test
    public void deleteAllExcludeRoot() {
        // exclude the root: "dog"
        String[] keys = {"alf", "bag", "cat", "flat", "glut", "elf"};
        for (String key: keys) {
            deleteNode(key);
        }
    }

    @Test
    public void deleteAll() {
        String[] keys = {"alf", "bag", "cat", "flat", "glut", "elf", "dog"};
        for (String key: keys) {
            deleteNode(key);
        }
    }

    @Test
    public void deleteAllRandomly() {
        String[] keys = {"alf", "bag", "cat", "flat", "glut", "elf", "dog"};
        List<String> list = Arrays.asList(keys);
        Collections.shuffle(list);
        for (String key: list) {
            deleteNode(key);
        }
    }

    private void deleteNode(String name) {
        BST<String> alf = this.bst.find(name);
        assertNotNull(alf);
        BST<String> deletedAlf = this.bst.delete(name);
        assertNotNull(deletedAlf);
        BST<String> noAlf = this.bst.find(name);
        assertNull(noAlf);
        assertTrue(bst.isValidate());
    }


    @Test
    public void insert() {
        String[] keys = {"dog", "alf", "bag", "cat", "flat", "glut", "elf"};
        for (String k: keys) {
            assertNotNull(bst.find(k));
        }
    }
}