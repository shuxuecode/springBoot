package leetcode;

import org.junit.jupiter.api.Test;

public class N53 {

    // 暴力解法
    public int maxSubArray2(int[] nums) {
        int length = nums.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            max = Math.max(max, num);
            for (int j = i + 1; j < length; j++) {
                num += nums[j];
                max = Math.max(max, num);
            }
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        int count = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            count = Math.max(count + nums[i], nums[i]);
            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}
