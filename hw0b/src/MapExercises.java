import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> aMap = new HashMap<>();
        char c = 'a';
        for (int i = 1; i <= 26; i++) {
            aMap.put((char)(c+i-1), i);
        }
        return  aMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> aMap = new HashMap<>();
        for(Integer i: nums) {
            aMap.put(i, i*i);
        }
        return aMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> aMap = new HashMap<>();
        for (String w: words) {
            if (aMap.get(w) == null) {
                aMap.put(w, 1);
            } else {
                int count = aMap.get(w);
                aMap.put(w, count+1);
            }
        }
        return aMap;
    }
}
