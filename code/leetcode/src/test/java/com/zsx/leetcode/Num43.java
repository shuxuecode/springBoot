package com.zsx.leetcode;

public class Num43 {


    public static void main(String[] args) {
        multiply("99", "456");
    }

    public static String multiply(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;

        int i = 1;

        while (len1 - i >= 0 || len2 - i >= 0) {
            Integer a = null;
            if (i <= len1) {
                char aa = chars1[len1 - i];
                a = aa - '0';
            }
            Integer b = null;
            if (i <= len2) {
                char bb = chars2[len2 - i];
                b = bb - '0';
            }

            System.out.println(a);
            System.out.println(b);


            i++;
        }


        return "";
    }

}
