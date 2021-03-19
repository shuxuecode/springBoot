package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N88 {


    @Test
    public void test() {


        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 5};

        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m + n - 1; i >= 0; i--) {
            if (m == 0) {
                nums1[i] = nums2[--n];
                continue;
            }
            if (n == 0) {
                nums1[i] = nums1[--m];
                continue;
            }
            int a = nums1[m - 1];
            int b = nums2[n - 1];
            if (a > b) {
                nums1[i] = a;
                m--;
            } else {
                nums1[i] = b;
                n--;
            }
        }

        Arrays.stream(nums1).forEach(System.out::println);

    }

}
