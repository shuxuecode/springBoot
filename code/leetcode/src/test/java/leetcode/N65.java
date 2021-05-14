package leetcode;

import org.junit.jupiter.api.Test;

// TODO zsx 
public class N65 {

    public boolean isNumber(String s) {
        char c = s.charAt(0);
        if (c == '+' || c == '+') {

        }

        return false;
    }

    public boolean 是否为整数(String s) {
        char first = s.charAt(0);
        if (first == '+' || first == '-') {
            isPureNumber(s.substring(1));
        }


        return false;
    }

    public boolean 是否为小数(String s) {
        return false;
    }

    // 是否为纯数字
    public boolean isPureNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5'
                    && c != '6' && c != '7' && c != '8' && c != '9') {
                return false;
            }
        }
        return true;
    }

    @Test
    void t() {

    }

}
