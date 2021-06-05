package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N217 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    @Test
    void t() {
        int[] nums = {1, 2, 3, 4};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
}
