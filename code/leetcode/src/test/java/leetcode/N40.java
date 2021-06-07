package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * todo
 */
public class N40 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        for (int i = 0; i < candidates.length; i++) {
            dfs(candidates, i, target, 0, new ArrayList<>());
        }

        return result;
    }

    public void dfs(int[] candidates, int i, int target, int sum, List<Integer> list) {
        if (i == candidates.length) {
            return;
        }
        sum += candidates[i];
        list.add(candidates[i]);

        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(list);
            return;
        }

        dfs(candidates, i + 1, target, sum, list);
    }


    // 这个错误
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int candidate : candidates) {
            Integer num = map.get(target - candidate);
            if (num != null && num > 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(candidate);
                list.add(target - candidate);

                resultList.add(list);
                map.put(target - candidate, --num);
            } else {
                Integer k = map.get(candidate);
                if (k == null) {
                    map.put(candidate, 1);
                } else {
                    map.put(candidate, ++k);
                }
            }
        }

        return resultList;
    }

    @Test
    void t() {
        int[] nums = {2, 2, 2, 3, 3};
        int target = 5;

        List<List<Integer>> lists = combinationSum(nums, target);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}
