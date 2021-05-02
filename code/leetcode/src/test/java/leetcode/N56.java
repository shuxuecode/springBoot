package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

// todo
public class N56 {


    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        int length = intervals.length;
        int i = 1;

        int[] nums = intervals[0];

        while (i < length) {


            if (intervals[i][0] <= nums[1]) {
                if (nums[0] <= intervals[i][0]) {
                    nums[0] = intervals[i][0];
                }
                nums[1] = intervals[i][1];
            } else {
                list.add(nums);
                nums = intervals[i];
            }
            i++;
        }
        list.add(nums);
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }

        return res;
    }


    @Test
    public void test() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 6};
        int[] nums3 = {8, 10};
        int[] nums4 = {15, 18};

        int[][] intervals = {nums1, nums2, nums3, nums4};

        int[][] res = merge(intervals);

        print(res);

    }

    public void print(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[ ");
            for (int i : interval) {
                System.out.print(i);
                System.out.print(" , ");
            }
            System.out.print(" ]");
            System.out.println();
        }
    }

}

