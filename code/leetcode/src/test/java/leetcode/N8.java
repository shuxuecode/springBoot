package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author zsx
 */
public class N8 {
    public int myAtoi(String s) {
        // TODO zsx
        return 0;
    }

    // 不能用Long的话，这个也不行
    public int myAtoi3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }


        char[] chars = s.toCharArray();

        ArrayList<Character> list = new ArrayList<>();

        // 1、去掉无用的前导空格
        for (char c : chars) {
            if (c == ' ' && list.size() == 0) {
                continue;
            }
            list.add(c);
        }

        if (list.size() == 0) {
            return 0;
        }


        // 是否为负数
        boolean negative = false;
        // 2、检查是否有+-号
        if (list.get(0) == '+') {
            list.remove(0);
        } else if (list.get(0) == '-') {
            negative = true;
            list.remove(0);
        }

        ArrayList<Character> newList = new ArrayList<>();
        for (Character character : list) {
            if (character >= '0' && character <= '9') {
                if (character == '0' && newList.size() == 0) {
                    // 排除前导0的情况
                } else {
                    newList.add(character);
                }
            } else {
                break;
            }
        }

        if (newList.size() == 0) {
            return 0;
        }

        int len = 10;
        if (newList.size() < 10) {
            len = newList.size();
        }


        char[] c = new char[len];
        for (int i = 0; i < len; i++) {
            c[i] = newList.get(i);
        }

        String str = String.valueOf(c);

        if (negative) {
            str = "-" + str;
        }

        Long aLong = Long.valueOf(str);

        if (aLong.longValue() <= Long.parseLong(String.valueOf(Integer.MIN_VALUE))) {
            return Integer.MIN_VALUE;
        }
        if (aLong.longValue() >= Long.parseLong(String.valueOf(Integer.MAX_VALUE))) {
            return Integer.MAX_VALUE;
        }
        return Integer.valueOf(str);
    }

    // 这个解法是错误的
    public int myAtoi2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {

            // 当有前置空格时跳过
            if (chars[i] == ' ') {
                // 如果中间有空格则跳出
                if (list.size() > 0) {
                    break;
                }
            } else if (chars[i] == '-' || chars[i] == '+') {
                // 如果第一次遇到+-号，则添加，否则跳出
                if (list.size() == 0) {
                    list.add(chars[i]);
                } else {
                    break;
                }
            } else if (chars[i] == '0') {
                // 对0特殊处理
                if (list.size() == 0) {

                } else if (list.size() == 1 && (list.get(0) == '-' || list.get(0) == '+')) {

                } else {
                    list.add(chars[i]);
                }
            } else if (chars[i] >= '1' && chars[i] <= '9') {
                list.add(chars[i]);
            } else {
                break;
            }
        }

        if (list.size() > 0) {

            // 避免特殊情况
            if (list.size() == 1 && (list.get(0) == '-' || list.get(0) == '+')) {
                return 0;
            }

            int len = 11;
            if (list.size() < 12) {
                // 防止长度过长，超过Long
                len = list.size();
            }

            char[] c = new char[len];
            for (int i = 0; i < len; i++) {
                c[i] = list.get(i);
            }

            String str = String.valueOf(c);

            Long aLong = Long.valueOf(str);

            if (aLong.longValue() <= Long.parseLong(String.valueOf(Integer.MIN_VALUE))) {
                return Integer.MIN_VALUE;
            }
            if (aLong.longValue() >= Long.parseLong(String.valueOf(Integer.MAX_VALUE))) {
                return Integer.MAX_VALUE;
            }
            return Integer.valueOf(str);
        }

        return 0;
    }


    @Test
    void t() {
        String s = "  0000000000012345678";

        int i = myAtoi(s);

        System.out.println(i);

        System.out.println(Integer.toBinaryString(9));

    }
}
