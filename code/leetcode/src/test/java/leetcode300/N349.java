package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author zsx
 */
public class N349 {

    // 暴力
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            res[i++] = num;
        }
        return res;
    }

    @Test
    void t() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] res = intersection(nums1, nums2);

        System.out.println(Arrays.toString(res));
    }
}
