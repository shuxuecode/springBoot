package leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class N26 {

    // 一次循环解法
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        int num = nums[index];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                num = nums[i];
                nums[++index] = num;
            }
        }
        return ++index;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < length) {
            if (nums[fast - 1] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }

    @Test
    void t() {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);

        System.out.println(i);
    }
}
