package Offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 */
public class Offer38 {
    List<String> res = new ArrayList<String>();

    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        dfs(s.toCharArray(), 0);

        return res.toArray(new String[res.size()]);
    }

    public void dfs(char[] str, int i) {
        if (i == str.length - 1) {
            res.add(String.valueOf(str));//String.valueOf将对象转换为string
        } else {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < str.length; j++) {
                if (set.contains(str[j])) {
                    // 遇到重复字符时不交换，直接跳过
                    continue;
                }
                set.add(str[j]);
                swap(str, i, j);
                dfs(str, i + 1);
                swap(str, i, j);
            }
        }
    }


    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    @Test
    void t() {
        String s = "abc";
        String[] strings = permutation(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
