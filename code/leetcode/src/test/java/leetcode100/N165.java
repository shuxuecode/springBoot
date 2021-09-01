package leetcode100;

import org.junit.jupiter.api.Test;

public class N165 {

    // 双指针  用时0ms，击败100%的用户
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;

        while (i < version1.length() && j < version2.length()) {
            int x = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                x = x * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;

            int y = 0;
            while (j < version2.length() && version2.charAt(j) != '.') {
                y = y * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        if (i < version1.length()) {
            while (i < version1.length() && (version1.charAt(i) == '.' || version1.charAt(i) == '0')) {
                i++;
            }
            if (i < version1.length()) {
                return 1;
            }
        }
        if (j < version2.length()) {
            while (j < version2.length() && (version2.charAt(j) == '.' || version2.charAt(j) == '0')) {
                j++;
            }
            if (j < version2.length()) {
                return -1;
            }
        }
        return 0;
    }

    // 使用了split 和 Integer.parseInt
    public int compareVersion2(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int length = Math.max(split1.length, split2.length);

        for (int i = 0; i < length; i++) {
            int a = 0;
            if (i < split1.length) {
                a = Integer.parseInt(split1[i]);
            }
            int b = 0;
            if (i < split2.length) {
                b = Integer.parseInt(split2[i]);
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
        }
        return 0;
    }

    @Test
    void t() {
        //String version1 = "0.1";
        //String version2 = "1.1";

        String version1 = "7.5.2.4", version2 = "7.5.3";

        int i = compareVersion(version1, version2);
        System.out.println(i);
    }
}
