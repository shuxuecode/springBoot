package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 * @date 2021/9/10
 */
public class N1894 {
    // 错误
    public int chalkReplacer1(int[] chalk, int k) {
        int n = chalk.length;

        int[] arr = new int[n];
        arr[0] = chalk[0];

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + chalk[i];
        }

        int i = k % arr[n - 1];

        if (i == 0) {
            return 0;
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] > i) {
                return j;
            }
        }

        return 0;
    }

    public int chalkReplacer(int[] chalk, int k) {


        int n = chalk.length;

        long count = chalk[0];

        for (int i = 1; i < n; i++) {
            count += chalk[i];
        }

        long j = k % count;

        for (int i = 0; i < n; i++) {
            j -= chalk[i];
            if (j < 0) {
                return i;
            }
        }

        return 0;
    }


    @Test
    void t() {
        //int i = chalkReplacer(new int[]{5, 1, 5}, 22);
        int i = chalkReplacer(new int[]{3, 4, 1, 2}, 25);

        System.out.println(i);
    }
}
