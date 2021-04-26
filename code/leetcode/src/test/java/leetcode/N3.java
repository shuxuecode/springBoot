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
        int n = s.length();
        // 答案
        int result = 0;
        int left = 0; // 滑动窗口左指针
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        for (int i = 0; i < n; i++) {
            System.out.println(map);
            if (map.containsKey(s.charAt(i))) {
                // 如果出现重复的，则更新左指针
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            // 不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i), i);
            // 比较当前字符长度 跟 最大长度
            result = Math.max(result, i - left + 1);
        }
        return result;
    }


    @Test
    public void t1() {
        System.out.println("abcd".charAt(1));
        int[] index = new int[128];

        System.out.println(index["abcd".charAt(1)]);
    }
}
