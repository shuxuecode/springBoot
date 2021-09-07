package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 * @date 2021/9/7
 */
public class N1221 {

    public int balancedStringSplit(String s) {
        int res = 0;

        int a = 0, b = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                a++;
            } else {
                b++;
            }

            if (a == b) {
                res++;
                a = b = 0;
            }
        }
        return res;
    }


    @Test
    void t() {
        String str = "RLRRLLRLRL";
        str = "LLLLRRRR";

        int i = balancedStringSplit(str);

        System.out.println(i);
    }

}

