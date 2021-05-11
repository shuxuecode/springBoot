package leetcode;

import org.junit.jupiter.api.Test;

public class N42 {


    // 动态规划
    public int trap2(int[] height) {

        int len = height.length;
        if (len < 2) {
            return 0;
        }
        //
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            // 存储当前元素左边最高柱子的高度
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        //
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i > 0; i--) {
            // 存储当前元素右边最高柱子的高度
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            // 每个柱子接的雨水 等于 该柱子左右两边最小值 减去 当前柱子的高度
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }

    // 双指针解法
    public int trap(int[] height) {
        int res = 0;

        int left = 0, right = height.length - 1;

        int leftMax, rightMax;
        leftMax = rightMax = 0;

        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    @Test
    void t() {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

//        int trap = trap(nums);
        int trap = trap2(nums);

        System.out.println(trap);
    }


}
