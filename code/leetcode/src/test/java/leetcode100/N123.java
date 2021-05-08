package leetcode100;

import org.junit.jupiter.api.Test;

public class N123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy1 = Math.min(buy1, prices[i]);

            sell2 = Math.max(sell2, prices[i] - buy2);
            buy2 = Math.min(buy2, prices[i] - sell1);
        }
        return sell2;
    }


    @Test
    public void test() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1, 2, 5, 2, 6};
        int maxProfit = maxProfit(prices);

        System.out.println(maxProfit);
    }


    public void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            int[] nums = dp[i];
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]);
                System.out.print(" , ");
            }
            System.out.println();
        }
    }
}
