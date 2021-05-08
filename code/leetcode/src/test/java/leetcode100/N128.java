package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int j = 0;
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - n == 1) {
                max = Math.max(max, i - j + 1);
            } else if (nums[i] == n) {
                j++;
            } else {
                j = i;
            }
            n = nums[i];
        }
        return max;
    }


    @Test
    public void test() {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {1, 2, 0, 1};

        int res = longestConsecutive(nums);

        System.out.println(res);

    }

}
