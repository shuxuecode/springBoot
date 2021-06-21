package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class N78 {

    // 通过
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, res);
        return res;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            ArrayList<Integer> list = new ArrayList<>(res.get(j));
            list.add(nums[i]);
            res.add(list);
        }
        dfs(nums, i + 1, res);
    }


    List<List<Integer>> result = new ArrayList<>();

    // 未通过，需要考虑 1,3 这种情况
    public List<List<Integer>> subsets2(int[] nums) {
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
