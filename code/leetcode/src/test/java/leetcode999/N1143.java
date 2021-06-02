package leetcode999;

import org.junit.jupiter.api.Test;

public class N1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int res = 0;

        int k = 0;

        for (int i = 0; i < chars1.length; i++) {
            for (int j = k; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    System.out.println("相等的两个： ");
                    System.out.print(chars1[i]);
                    System.out.print(chars2[j]);
                    k = j;
                    res++;
                    break;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        String text1 = "abcde";
        String text2 = "ace";

//        System.out.println(longestCommonSubsequence(text1, text2));

//        System.out.println(longestCommonSubsequence("abc", "def"));

        System.out.println(
                longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));

    }
}
