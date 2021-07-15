package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N137 {

    //    通过，2ms，超过83%
    public int singleNumber2(int[] nums) {
        int num = nums[0];
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            System.out.println(i);
            if (i == len - 1) {
                return nums[len - 1];
            }
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }
        }

        return num;
    }

//    与非门 todo
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    @Test
    void t() {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int singleNumber = singleNumber(nums);

        System.out.println(singleNumber);
    }
}
