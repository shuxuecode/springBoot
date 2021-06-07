package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N494 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target || nums[0] == -target) {
                return 1;
            } else {
                return 0;
            }
        }

        dfs(nums, 0, nums[0], target);
        dfs(nums, 0, -nums[0], target);

        return count;
    }

    public void dfs(int[] nums, int i, int sum, int target) {
        i++;
        if (i == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(nums, i, sum + nums[i], target);
        dfs(nums, i, sum - nums[i], target);
    }

    @Test
    void t() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = -3;

        int targetSumWays = findTargetSumWays(nums, target);

        System.out.println(targetSumWays);
    }
}
