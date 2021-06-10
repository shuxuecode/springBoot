package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zsx
 */
public class N518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            System.out.println("当然硬币面额=" + coin);
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                System.out.println(Arrays.toString(dp));
            }
        }

        return dp[amount];
    }

    @Test
    void t() {
        int amount = 5;
        int[] coins = {1, 2, 5};

        int change = change(amount, coins);

        System.out.println(change);
    }
}
