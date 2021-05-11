package leetcode;

import org.junit.jupiter.api.Test;

public class N4 {


    // 暴力解法
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int length = len1 + len2;

        boolean bool = length % 2 == 0;
        // 一半的长度
//        int halfLen = bool ? length / 2 : (length / 2) + 1;
        int halfLen = length / 2;

        int[] nums = new int[halfLen + 1];

        int n, m;
        n = m = 0;
        for (int i = 0; i <= halfLen; i++) {
            if (n < len1 && m < len2) {
                if (nums1[n] < nums2[m]) {
                    nums[i] = nums1[n];
                    n++;
                } else {
                    nums[i] = nums2[m];
                    m++;
                }
            } else {
                if (n < len1) {
                    nums[i] = nums1[n];
                    n++;
                }
                if (m < len2) {
                    nums[i] = nums2[m];
                    m++;
                }
            }
        }
        return bool ? (nums[halfLen - 1] + nums[halfLen]) / 2.0 : nums[halfLen];
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }


    @Test
    void test() {
        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4, 5};
        int[] nums2 = {3, 4};

        double num = findMedianSortedArrays2(nums1, nums2);

        System.out.println(num);

    }

    public void print(int[] nums) {
        System.out.println();
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" , ");
        }
        System.out.println();
    }
}
