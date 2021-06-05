package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 按奇偶排序数组 II
 */
public class N922 {

    public int[] sortArrayByParityII(int[] nums) {

        int i = 0;
        int j = 1;

        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] % 2 == 0) {
                i += 2;
            }

            while (j < nums.length && nums[j] % 2 == 1) {
                j += 2;
            }

            if (i < nums.length && j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i += 2;
                j += 2;
            }
        }
        return nums;
    }


    @Test
    void t() {
        int[] nums = {4, 2, 5, 7};
        int[] array = sortArrayByParityII(nums);

        System.out.println(Arrays.toString(array));
    }
}
