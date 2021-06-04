package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zsx
 * <p>
 * todo
 */
public class N47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        dfs(nums, used, 0, resultList);

        return resultList;
    }

    public void dfs(int[] nums, boolean[] used, int first, List<List<Integer>> res) {
        if (first == nums.length) {
            res.add(getList(nums));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1]) && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            swap(nums, first, i);
            dfs(nums, used, first + 1, res);
            used[i] = false;
            swap(nums, first, i);
        }
    }

    public List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    void t() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);

        System.out.println(lists);
    }
}
