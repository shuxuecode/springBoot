package leetcode300;

import org.junit.jupiter.api.Test;

public class N343 {

    // todo zsx
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; ++i) {
            for (int j = 2; j <= i / 2; ++j) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        return dp[n];
    }


    @Test
    void t() {
        System.out.println(integerBreak(10));
    }
}
