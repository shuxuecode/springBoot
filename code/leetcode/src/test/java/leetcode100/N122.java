package leetcode100;

import org.junit.jupiter.api.Test;

public class N122 {

    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    @Test
    public void test() {
//        int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {1, 2, 5, 2, 6};

//        int maxProfit = maxProfit(prices);
        int maxProfit = maxProfit2(prices);

        System.out.println(maxProfit);
    }
}
