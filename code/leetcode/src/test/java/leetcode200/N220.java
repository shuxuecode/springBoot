package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N220 {


    // 超出时间限制 todo
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                long a = nums[i] * 1L;
                long b = nums[j] * 1L;
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    void t() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;

//        boolean b = containsNearbyAlmostDuplicate(nums, k, t);

//        boolean b = containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2);

//        boolean b = containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);

        boolean b = containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);

        System.out.println(-2147483648);

        System.out.println(b);
    }
}
