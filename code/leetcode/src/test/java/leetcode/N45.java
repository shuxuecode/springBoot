package leetcode;

import org.junit.jupiter.api.Test;

public class N45 {
    // 超出时间限制
    public int jump1(int[] nums) {
        int step = 0;

        // 当前坐标
        int i = 0;
        // 当前坐标的值，表示可以走几步
        int num = nums[i];

        int max = 0;
        int maxNum = 0;

        while (i + num < nums.length) {
            for (int j = i; j <= (i + num); j++) {
                if (nums[j] > maxNum) {
                    maxNum = nums[j];
                    max = j;
                }
            }

            i = max;
            num = maxNum;

            step++;
        }

        return step;
    }

    // 超出时间限制
    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;

        // 当前坐标
        int i = 0;
        // 当前坐标的值，表示可以走几步
        int num = nums[i];
        // 记录最大值所在的坐标
        int max = 0;

        while ((i + 1 + num) < nums.length) {
            for (int j = i + 1; j <= (i + num); j++) {
                if (nums[j] >= nums[max]) {
                    max = j;
                }
            }

            i = max;
            num = nums[i];

            step++;
        }

        step++;

        return step;
    }

    // 解答错误
    public int jump3(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;

        // 当前坐标
        int i = 0;
        // 当前坐标的值，表示可以走几步
        int num = nums[i];
        // 记录最大值所在的坐标
        int max = 0;
        // i+1 再加上步数就等于长度
        while ((i + 1 + num) < nums.length) {

            max = i + 1;

            // 从下一个区间的第二个值开始比较，跟第一个值比较
            for (int j = max + 1; j <= i + num; j++) {
                if (nums[j] >= nums[max]) {
                    max = j;
                }
            }

            i = max;
            num = nums[i];

            step++;
        }

        step++;

        return step;
    }

    // 100%通过
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;

        // 当前坐标
        int i = 0;
        // 能够到达的最大坐标
        int max = i + nums[i];

        while (max + 1 < nums.length) {
            int m = i;
            int n = i + nums[i];
            for (int j = m; j <= n; j++) {
                if ((j + nums[j]) >= max) {
                    max = j + nums[j];
                    i = j;
                }
            }
            step++;
        }

        step++;

        return step;
    }

    @Test
    void t() {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {0};
//        int[] nums = {2, 1};
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 1, 1, 1};
        int[] nums = {1, 2, 1, 1, 1};
//        int[] nums = {1, 3, 2};
//        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        int i = jump(nums);
        System.out.println(i);
    }
}
