package leetcode300;

import org.junit.jupiter.api.Test;

public class N374 {

    static int pick = 1702766719;

    public int guessNumber(int n) {
        return dfs(1, n);
    }

    public int dfs(int low, int high) {
        if (high - low == 1) {
            if (guess(low) == 0) {
                return low;
            } else if (guess(high) == 0) {
                return high;
            }
        }

        // 要注意int越界的情况
        int mid = (int) (((long) low + (long) high) / 2L);
        int guess = guess(mid);
        if (guess == -1) {
            return dfs(low, mid);
        } else if (guess == 1) {
            return dfs(mid, high);
        } else {
            return mid;
        }
    }


    public static int guess(int num) {
        if (pick < num) return -1;
        if (pick > num) return 1;
        return 0;
    }


    @Test
    void t() {
        guessNumber(2126753390);
    }
}
