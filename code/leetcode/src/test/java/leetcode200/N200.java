package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class N200 {


    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num = get(grid, i, j);
                if (num > 0) {
                    res++;
                }
            }
        }

        return res;
    }


    public int get(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0') {
            return 0;
        }
        grid[row][col] = '0';
        int num = 1;
        num += get(grid, row - 1, col);
        num += get(grid, row + 1, col);
        num += get(grid, row, col - 1);
        num += get(grid, row, col + 1);
        return num;
    }


    @Test
    void t() {
        char[] row1 = {'1', '1', '0', '0', '0' };
        char[] row2 = {'1', '1', '0', '0', '0' };
        char[] row3 = {'0', '0', '1', '0', '0' };
        char[] row4 = {'0', '0', '0', '1', '1' };

        char[][] grid = {row1, row2, row3, row4};

        int num = numIslands(grid);
        System.out.println(num);
    }
}
