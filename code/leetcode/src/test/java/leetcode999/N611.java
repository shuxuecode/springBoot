package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N611 {

    // 排序+ 双指针
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }



    // todo zsx
    public int triangleNumber2(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {



            }

        }


        return res;
    }


    @Test
    void t() {
        int[] nums = {2, 2, 3, 4};

        int i = triangleNumber(nums);

        System.out.println(i);

    }
}
