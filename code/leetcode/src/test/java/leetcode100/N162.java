package leetcode100;

import org.junit.jupiter.api.Test;

/**
 */
public class N162 {

    // 不能解决[1,2]这种情况
    public int findPeakElement2(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return i;
    }

    @Test
    void t() {
        //int i = findPeakElement(new int[]{1, 2, 3, 1});
        //int i = findPeakElement(new int[]{1, 2});
        //int i = findPeakElement(new int[]{1, 2, 3});
        int i = findPeakElement(new int[]{5, 2, 3});
        System.out.println(i);
    }


}
