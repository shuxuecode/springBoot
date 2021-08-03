package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class N395 {

    // 超时了
    public int longestSubstring2(String s, int k) {

        ArrayList<String> list = new ArrayList<>();
        int length = s.length();

        for (int i = 0; i <= length - k; i++) {
            for (int j = i + k; j <= length; j++) {
                list.add(s.substring(i, j));
            }
        }

        int max = 0;
        for (String str : list) {
            boolean bool = checkStr(str, k);
            if (bool) {
                max = Math.max(max, str.length());
            }
        }

        return max;
    }

    public boolean checkStr(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = str.toCharArray();

        for (char c : array) {
            Integer num = map.get(c);
            if (num == null) {
                map.put(c, 1);
            } else {
                map.put(c, num + 1);
            }
        }

        for (Integer value : map.values()) {
            if (value < k) {
                return false;
            }
        }

        return true;
    }


    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }


    @Test
    void t() {
        String s = "ababbc";
        int k = 2;


//        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        k = 1;
        int longestSubstring = longestSubstring(s, k);
        System.out.println(longestSubstring);
    }
}
