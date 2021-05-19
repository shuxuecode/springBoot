package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N40 {
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

        List<List<Integer>> lists = combinationSum2(nums, target);

        for (List<Integer> list : lists) {
            System.out.println();
            for (Integer integer : list) {
                System.out.print(integer);
                System.out.print(" , ");
            }
        }
    }
}
