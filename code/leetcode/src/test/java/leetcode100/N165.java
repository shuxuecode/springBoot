package leetcode100;

import org.junit.jupiter.api.Test;

public class N165 {

    public int compareVersion(String version1, String version2) {
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
        String version1 = "0.1";
        String version2 = "1.1";

        int i = compareVersion(version1, version2);
        System.out.println(i);
    }
}
