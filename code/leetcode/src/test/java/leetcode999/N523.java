package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * 连续的子数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 *
 * @author zsx
 */
public class N523 {


    // 暴力解法
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum;

        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    void t() {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        k = 13;

        boolean b = checkSubarraySum(nums, k);
        System.out.println(b);
    }

}
