package leetcode999;

import org.junit.jupiter.api.Test;

public class N443 {
    public int compress(char[] chars) {
        int len = chars.length;
        // 写指针
        int k = 0;

        for (int i = 0; i < len; ) {

            int j = i;
            // 判断是否有重复，有则指针+1，否则记录当前字符
            while (j < len && chars[i] == chars[j]) {
                j++;
            }
            // 记录不重复字符
            chars[k++] = chars[i];
            // 当长度大于1时，记录一下数字
            if (j - i > 1) {
                String num = Integer.toString(j - i);
                // 遍历数字，存放到chars数组中
                for (int m = 0; m < num.length(); m++) {
                    chars[k++] = num.charAt(m);
                }
            }
            // 指针赋值
            i = j;
        }
        return k;
    }

    @Test
    void t() {
        char[] chars = {'a', 'b', 'b', 'b'};

        int compress = compress(chars);

        System.out.println(compress);

    }
}
