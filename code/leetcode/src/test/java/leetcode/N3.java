package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class N3 {

    @Test
    public void test() {
        int i = lengthOfLongestSubstring("aabcdea");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    @Test
    public void test2() {
        int i = lengthOfLongestSubstring2("ababcdea");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            System.out.println(map);
            if (map.containsKey(s.charAt(j))) {
                // 如果出现重复的，则重置i游标
                i = Math.max(map.get(s.charAt(j)), i);
            }
            System.out.println(i);
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    @Test
    public void t1() {
        System.out.println("abcd".charAt(1));
        int[] index = new int[128];

        System.out.println(index["abcd".charAt(1)]);
    }
}
