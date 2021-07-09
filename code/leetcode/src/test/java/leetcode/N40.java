package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * todo
 */
public class N40 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int length = candidates.length;
        if (length == 0) {
            return result;
        }

        // 排序
        Arrays.sort(candidates);

        // 存储已存在的路径
        Deque<Integer> path = new ArrayDeque<>(length);

        dfs(candidates, length, 0, target, path, result);

        return result;
    }

    /**
     * @param candidates
     * @param len
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    public void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            //
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
        }
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
