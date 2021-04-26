package leetcode;

import org.junit.jupiter.api.Test;

public class N5 {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLongStr(s, i, i);
            int len2 = getLongStr(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int getLongStr(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            --left;
//            ++right;
            left--;
            right++;
        }
        return right - left - 1;
    }


    @Test
    public void test() {
        String s = "babad";
        String str = longestPalindrome(s);
        System.out.println(str);

    }
}
