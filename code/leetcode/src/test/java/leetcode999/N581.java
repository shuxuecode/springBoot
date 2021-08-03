package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N581 {

    // 未通过
    public int findUnsortedSubarray2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        if (nums.length == 2){
            if (nums[0] < nums[1]){
                return 0;
            }else{
                return 2;
            }
        }

        int i = 0;
        int j = nums.length - 1;

        for (int m = 0; m < nums.length - 1; m++) {
            if (m == 0) {
                if (nums[m] >= nums[m + 1]) {
                    i = 0;
                    break;
                }
            } else {
                if (nums[m] >= nums[m - 1] && nums[m] <= nums[m + 1]) {
                    i = m;
                } else {
                    i = m;
                    break;
                }
            }
        }

        for (int n = nums.length - 1; n > 0; n--) {
            if (n == nums.length - 1) {
                if (nums[n] <= nums[n - 1]) {
                    j = nums.length - 1;
                    break;
                }
            } else {
                if (nums[n] >= nums[n - 1] && nums[n] <= nums[n + 1]) {
                    j = n;
                } else {
                    j = n;
                    break;
                }
            }
        }

        if (i >= j) {
            return 0;
        }

        int res = 0;
        res = j - i + 1;

        return res;
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }


    @Test
    void t() {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {5,4,3,2,1};
//        int[] nums = {1,2,3,3,3};
        int[] nums = {1,3,2,2,2};

        int i = findUnsortedSubarray(nums);

        System.out.println(i);
    }
}
