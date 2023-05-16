import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for (int i: L) {
            sum += i;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> alist = new ArrayList<>();
        for (int i: L) {
            if (i % 2 == 0) {
                alist.add(i);
            }
        }
        return alist;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        Collection<Integer> c = CollectionUtils.intersection(L1, L2);
        List<Integer> alist = new ArrayList<>(c);
        return alist;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String e: words) {

            String target = String.valueOf(c);
            if (e.contains(target)) {
                count += 1;
            }
        }
        return  count;
    }
}
