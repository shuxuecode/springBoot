package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 *
 * todo
 *
 */
public class N1254 {

    public int closedIsland(int[][] grid) {

        return 0;
    }

    @Test
    void t() {
        int[] nums1 = {0, 0, 1, 0, 0};
        int[] nums2 = {0, 1, 0, 1, 0};
        int[] nums3 = {0, 1, 1, 1, 0};

        int[][] grid = {nums1, nums2, nums3};

        int i = closedIsland(grid);

        System.out.println(i);
    }


}
