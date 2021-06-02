package leetcode999;

import org.junit.jupiter.api.Test;

public class N704 {

    public int search(int[] nums, int target) {

        int i = erfen(nums, 0, nums.length - 1, target);

        return i;
    }

    public int erfen(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (nums[mid] > target) {
            return erfen(nums, low, mid - 1, target);
        }

        if (nums[mid] < target) {
            return erfen(nums, mid + 1, high, target);
        }

        return mid;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int search = search(nums, 7);
        System.out.println(search);
    }
}
