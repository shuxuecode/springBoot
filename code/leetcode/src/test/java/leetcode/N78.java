package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// todo 需要考虑 1,3 这种情况
public class N78 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        result.add(list);

        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, i);
        }

        return result;
    }

    public void dfs(int[] nums, int start, int end) {
        if (end == nums.length) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(nums[i]);
        }
        result.add(list);

        end++;
        dfs(nums, start, end);
    }


    @Test
    void t() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);

        System.out.println(list);
    }
}
