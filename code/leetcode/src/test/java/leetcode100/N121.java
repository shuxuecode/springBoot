package leetcode100;

import org.junit.jupiter.api.Test;

public class N121 {

    /**
     * 暴力解法，超出时间限制
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int num = prices[j] - prices[i];
//                max = Math.max(max, num);
                if (num > 0 && num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0, len = prices.length; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxprofit) {
                maxprofit = prices[i] - min;
            }
        }
        return maxprofit;
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int maxProfit = maxProfit(prices);

        System.out.println(maxProfit);
    }
}
