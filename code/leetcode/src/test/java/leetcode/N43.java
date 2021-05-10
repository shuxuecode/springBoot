package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N43 {

    @Test
    public void test() {
        String multiply = multiply("808", "88");
//        String multiply = multiply("5", "11");
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder str1 = new StringBuilder(num1);
        StringBuilder str2 = new StringBuilder(num2);

        str1.reverse();
        str2.reverse();

        int[] arr = new int[str1.length() + str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) != '0' && str2.charAt(j) != '0') {
                    arr[i + j] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
                }
            }
        }

        Arrays.stream(arr).forEach(item -> System.out.println(item));

        int tmp = 0; // 进位
        for (int i = 0; i < arr.length; i++) {
            arr[i] += tmp;
            tmp = arr[i] / 10;
            arr[i] %= 10;
        }

        Arrays.stream(arr).forEach(System.out::println);

        int len = 0;
        if (arr[arr.length - 1] == 0) {
            len = arr.length - 2;
        } else {
            len = arr.length - 1;
        }

        StringBuilder res = new StringBuilder();
        for (int i = len; i >= 0; i--) {
            res.append(arr[i]);
        }

        return res.toString();
    }

    // TODO zsx 
    public String multiply2(String num1, String num2) {
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
