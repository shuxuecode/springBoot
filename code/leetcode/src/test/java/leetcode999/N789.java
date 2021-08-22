package leetcode999;

import org.junit.jupiter.api.Test;

public class N789 {

    /**
     * 执行用时：0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：38.1 MB , 在所有 Java 提交中击败了 37.06% 的用户
     *
     * @param ghosts
     * @param target
     * @return
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};

        int minStep = minStep(source, target);

        for (int[] ghost : ghosts) {

            if (minStep(ghost, target) <= minStep) {
                return false;
            }
        }

        return true;
    }

    // 获取最短路径
    private int minStep(int[] ghost, int[] target) {
        return Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
    }

    @Test
    void t() {

        int[] ghost1 = {1, 0};
        int[] ghost2 = {0, 3};
//        int[] ghost3 = {1, 0};

        int[][] ghosts = new int[][]{ghost1, ghost2};

        int[] target = {0, 1};

        boolean bool = escapeGhosts(ghosts, target);

        System.out.println(bool);
    }
}
