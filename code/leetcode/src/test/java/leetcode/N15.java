package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// TODO zsx


public class N15 {

    public List<List<Integer>> threeSum(int[] nums) {

        quickSort(nums, 0, nums.length - 1);




        return null;
    }

    public void quickSort(int[] nums, int low, int high) {
        int mid;
        if (low < high) {
            mid = getMid(nums, low, high);
            quickSort(nums, mid + 1, high);
            quickSort(nums, low, mid - 1);
        }
    }

    public int getMid(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));


    }
}
