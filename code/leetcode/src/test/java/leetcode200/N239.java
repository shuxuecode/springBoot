package leetcode200;

import org.junit.jupiter.api.Test;

public class N239 {

    // 超出时间限制
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] res = new int[len];

        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            res[left] = getMax(nums, left, right);
            left++;
            right++;
        }
        return res;
    }

    public int getMax(int[] nums, int left, int right) {
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // 还是超出了时间限制
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        nums[0] = nums[maxIndex];
        int left = 1;
        for (int i = k; i < nums.length; i++) {
            if (maxIndex < left) {
                maxIndex = getMaxIndex(nums, left, i);
            } else {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            nums[left] = nums[maxIndex];
            left++;
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public int getMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {


        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    @Test
    void t() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        print(nums);
        int[] max = maxSlidingWindow(nums, k);
        print(max);

    }

    public void print(int[] nums) {
        System.out.println();
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" , ");
        }
        System.out.println();
    }
}
