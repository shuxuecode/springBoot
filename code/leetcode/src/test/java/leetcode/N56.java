package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// todo
public class N56 {


    public int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        int len = intervals.length;
        int[][] merge = new int[len][2];

        int k = 0;
        int i = 0;
        while (i < len) {
            int t = intervals[i][1];
            int j = i + 1;

            while (j < len && t >= intervals[j][0]) {
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            merge[k][0] = intervals[i][0];
            merge[k][1] = t;
            k++;

            i = j;
        }

        return Arrays.copyOf(merge, k);
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; ) {

            int t = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= t) {
                t = Math.max(t, intervals[j][1]);
                j++;
            }

//            merged.add();  // todo

            i = j;
        }

        return merged.toArray(new int[merged.size()][]);

    }



    // case无法全通过
    public int[][] merge2(int[][] intervals) {
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

