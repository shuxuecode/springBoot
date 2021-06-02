package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * 数字 1 的个数
 * <p>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * @author zsx
 */
public class N233 {

    // 超时
    public int countDigitOne2(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            str.append(i);
        }
        char[] chars = str.toString().toCharArray();
        int num = 0;
        for (char c : chars) {
            if (c == '1') {
                num++;
            }
        }
        return num;
    }


    // 超时
    public int countDigitOne3(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    num++;
                }
            }
        }
        return num;
    }

    public int countDigitOne(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if (str.indexOf('1') != -1) {
                char[] chars = str.toCharArray();
                for (char c : chars) {
                    if (c == '1') {
                        num++;
                    }
                }
            }
        }
        return num;
    }


    @Test
    void t() {
        System.out.println(countDigitOne(13));
        // 13 12 11 10 1
    }
}
