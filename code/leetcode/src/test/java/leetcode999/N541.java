package leetcode999;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int n = 0;
        int m = 0;

        for (int i = 0; i < chars.length; i++) {
            if (m == k * 2) {
                change(chars, n, n + k - 1);
                m = 1;
                n = i;
            } else {
                m++;
            }
        }
        if (m < k) {
            change(chars, n, chars.length - 1);
        } else if (m <= k * 2) {
            change(chars, n, n + k - 1);
        }
        return String.valueOf(chars);
    }

    public void change(char[] chars, int n, int m) {
        while (n < m) {
            char temp = chars[n];
            chars[n] = chars[m];
            chars[m] = temp;
            n++;
            m--;
        }
    }


    @Test
    public void test() {
        String s = "abcdefg";
        s = "abcd";
        s = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
        int k = 2;
        k = 20;

        String str = reverseStr(s, k);

//        System.out.println(s);
        System.out.println(str);
        System.out.println("jlnnxsetgcpsbhsfymrkhfursyissjnsocgdhgfxtxrlvugsaphqzxllwebukgatzfybprfmmfithphccxfsogsgqsnvckjvnskk");
        System.out.println(str.equals("jlnnxsetgcpsbhsfymrkhfursyissjnsocgdhgfxtxrlvugsaphqzxllwebukgatzfybprfmmfithphccxfsogsgqsnvckjvnskk"));

        Assertions.assertEquals(s, str, "相等");
    }
}
