package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 * @date 2021/9/21
 */
public class N58 {
    public int lengthOfLastWord(String s) {
        int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (res == 0) {
                    continue;
                } else {
                    return res;
                }
            } else {
                res++;
            }
        }

        return res;
    }

    @Test
    void t() {

        String s = "hello world";

        int length = lengthOfLastWord(s);
        System.out.println(length);
    }
}
