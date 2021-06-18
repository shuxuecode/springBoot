package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zsx
 */
public class N34 {


    // 二分法，手动处理了太多的特殊情况，但表现很好，执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int index = erfen(nums, 0, nums.length - 1, target);

        if (index != -1) {
            int i = index;
            int j = index;
            while (i >= 0 && nums[i] == target) {
                res[0] = i;
                i--;
            }
            while (j < nums.length && nums[j] == target) {
                res[1] = j;
                j++;
            }
        }

        return res;
    }

    public int erfen(int[] nums, int left, int right, int target) {
        if (right < 0) {
            return -1;
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        if (left >= right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            // 目标值在左边
            return erfen(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            // 目标值在右边
            return erfen(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    // 暴力解法，性能很差
    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                }
                res[1] = i;
            }
        }

        return res;
    }


    @Test
    void t() {
        int[] nums = {5, 7, 7, 8, 8, 10};

//        int[] range = searchRange(nums, 8);
        int[] range = searchRange(new int[]{2, 2}, 1);

        System.out.println(Arrays.toString(range));
    }
}
