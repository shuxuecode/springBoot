package Offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 */
public class Offer38 {
    static ArrayList<String> res = new ArrayList<String>();

    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        permutationHelper(s.toCharArray(), 0);
        String[] strs = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            strs[i] = res.get(i);
        }
        return strs;
    }

    public void permutationHelper(char[] str, int i) {
        if (i == str.length - 1) {
            res.add(String.valueOf(str));//String.valueOf将对象转换为string
        } else {
            for (int j = i; j < str.length; j++) {
                if (j != i && str[i] == str[j]) {
                    continue;
                }
                swap(str, i, j);
                permutationHelper(str, i + 1);
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
