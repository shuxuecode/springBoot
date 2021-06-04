package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author zsx
 */
public class N46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        dfs(nums, 0, resultList);

        return resultList;
    }

    public void dfs(int[] nums, int first, List<List<Integer>> res) {
        if (first == nums.length) {
            res.add(getList(nums));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            swap(nums, first, i);
            dfs(nums, first + 1, res);
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
//        int[] nums = {1, 2, 3};
        int[] nums = {1, 1, 3};
        List<List<Integer>> lists = permute(nums);

        System.out.println(lists);
    }
}
