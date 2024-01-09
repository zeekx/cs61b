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
    BST<String, String> bst;
    @Before
    public void setUp() throws Exception {
        BST<String, String> bst = new BST<>("dog", "dog");
        this.bst = bst;

        bst.insert("bag", "bag");
        bst.insert("alf", "alf");
        bst.insert("cat", "cat");

        bst.insert("flat", "flat");
        bst.insert("elf", "elf");
        bst.insert("glut", "glut");
    }


    @Test
    public void checkDog() {
        assertTrue(bst.isValidate());
    }

    @Test
    public void check() {
        BST<String, String> bst = new BST<>("=", "=");
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
        BST<String, String> bst = this.bst.delete("dog");
        assertNotNull(bst);
        assertTrue(bst.isValidate());
    }

    @Test
    public void deleteAlf() {
        BST<String, String> alf = this.bst.find("alf");
        assertNotNull(alf);
        BST<String, String> deletedAlf = this.bst.delete("alf");
        assertNotNull(deletedAlf);
        BST<String, String> noAlf = this.bst.find("alf");
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

    @Test
    public void deleteAllRandomlyLarge() {
        String[] randomWords = { "xwtsn", "mlfyb", "gwlq", "aztkkcrs", "kqfqjnt", "puaawhquxh", "aalfodmrp", "hcggpbp",
                "gulzpqtrc", "wzyxao", "ggg", "joqiqopgr", "ywxcrgernr", "ekgcmxrcg", "fbmt", "zsnw", "vts", "uwluyzhk",
                "ohnow", "xjllod", "flkttjh", "blbeozzc", "juteyjzjga", "uaghf", "tbsjjs", "vpicpqsuqj", "eseta",
                "sowsgbfew", "bolhtbjds", "kywx", "sdtez", "vwjdkxqgo", "hzr", "zopmnj", "czpajwmv", "ncnpivwkn",
                "xwxdf", "ayrobmnh", "kariixfxgt", "brirv", "xedpjluzjk", "qftovq", "sncrvb", "qmdojs", "gmrkf",
                "qrmnq", "vqshmqzu", "zhyhfdv", "iopmj", "xsv", "xks", "xiv", "okoowc", "vhgb", "kkdskegns",
                "pqwdoysyd", "xpunzvzzel", "styu", "hqtoyy", "xfvplup", "ttovnn", "olfyuklsy", "sfhbqfwv", "xxkngmd",
                "anns", "gor", "vdwiiicovn", "pcrjpcens", "yzxgmls", "xqqncfww", "fmz", "hvtnhiea", "ejcxyne",
                "iivkiib", "ijrsxwf", "zwpgvwy", "gtqbl", "kcmwazb", "vea", "scg", "ffjabgmh", "rinjzaocnl", "pjokhj",
                "zatz", "twdpcmif", "smqfbwobqm", "alvk", "ozndyji", "cnq", "johlllg", "kthxhlmhet", "uhus",
                "tsmdclduh", "fpxxdbskf", "fjmplulhi", "jpginrkfa", "atss", "wctjtjrqt", "vkwndzedn", "ythrzyjxp" };
        List<String> list = Arrays.asList(randomWords);
        this.bst = new BST<>();

        Collections.shuffle(list);
        for (String key: list) {
            bst.insert(key, key);
        }

        Collections.shuffle(list);
        for (String key: list) {
            deleteNode(key);
        }
    }

    private void deleteNode(String name) {
        BST<String, String> node = this.bst.find(name);
        assertNotNull(node);
        BST<String, String> deletedNode = this.bst.delete(name);
        assertNotNull(deletedNode);
        BST<String, String> nothing = this.bst.find(name);
        assertNull(nothing);
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