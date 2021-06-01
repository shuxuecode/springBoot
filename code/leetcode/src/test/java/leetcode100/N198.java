package leetcode100;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class N198 {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[length - 1];
    }


    @Test
    void t() {
        int[] nums = {2, 7, 9, 3, 1};
        int n = rob(nums);

        System.out.println(n);
    }
}
