package leetcode;

import org.junit.jupiter.api.Test;

/**
 *
 */
public class N695 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉没。
    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int num = 1;
        num += dfs(grid, row - 1, col);
        num += dfs(grid, row + 1, col);
        num += dfs(grid, row, col - 1);
        num += dfs(grid, row, col + 1);
        return num;
    }


    @Test
    void t() {
        int[] arr1 = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        int[] arr2 = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        int[] arr3 = {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr4 = {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0};
        int[] arr5 = {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0};
        int[] arr6 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        int[] arr7 = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        int[] arr8 = {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};

        int[][] grid = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};

        int i = maxAreaOfIsland(grid);

        System.out.println(i);

    }

}
