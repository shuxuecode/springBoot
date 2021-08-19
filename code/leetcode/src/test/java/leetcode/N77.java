package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class N77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {

        // 终止条件: path长度等于k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {

            path.addLast(i);
            // 递归
            dfs(n, k, i + 1, path, res);

            // 注意要把之前的数据逆向清空一次 todo
            path.removeLast();
        }
    }

    @Test
    void t() {
        List<List<Integer>> list = combine(4, 2);

        for (List<Integer> integers : list) {
            System.out.println(integers);
        }

    }

}
