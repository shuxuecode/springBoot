package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class N524 {

    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, (a, b) -> {
            // todo 这种比较方式做不到字典序最小
            //int len1 = a.length();
            //int len2 = b.length();
            //return len1 < len2 ? 1 : (len1 == len2 ? 0 : -1);
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return b.length() - a.length();
            }
        });

        for (String str : dictionary) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == str.length()) {
                return str;
            }
        }

        return "";
    }

    @Test
    void t() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");

        String longestWord = findLongestWord("abpcplea", dictionary);

        System.out.println(longestWord);
    }
}
