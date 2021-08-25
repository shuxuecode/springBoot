package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N797 {

    int[][] array;
    int n;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        array = graph;
        // 最大值
        n = graph.length - 1;

        list.add(0);

        dfs(0);

        return res;
    }

    private void dfs(int num) {

        if (num == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        //
        int[] targetArray = array[num];

        for (int target : targetArray) {
            list.add(target);
            dfs(target);
            list.remove(list.size() - 1);
        }
    }


    @Test
    void t() {
        // [[4,3,1],[3,2,4],[3],[4],[]]
        int[] a = {4, 3, 1};
        int[] b = {3, 2, 4};
        int[] c = {3};
        int[] d = {4};
        int[] e = {};


        int[][] graph = new int[][]{a, b, c, d, e};


        List<List<Integer>> lists = allPathsSourceTarget(graph);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}
