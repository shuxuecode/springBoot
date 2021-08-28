package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N1480 {
    public int[] runningSum(int[] nums) {
        for(int i=1, len=nums.length; i<len; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }

    @Test
    void t(){
        int[] nums = {1,1,1,1,1};

        int[] sum = runningSum(nums);


        System.out.println(Arrays.toString(sum));
    }

}
