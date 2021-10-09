package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SummaryRanges {

    List<Integer> list;

    public SummaryRanges() {
        list = new ArrayList<>();
    }

    public void addNum(int val) {
        if (list.isEmpty()) {
            list.add(val);
            list.add(val);
            return;
        }
        for (int i = 0; i < list.size(); i += 2) {
            Integer left = list.get(i);
            Integer right = list.get(i + 1);


        }
    }

    public int[][] getIntervals() {
        list.get(0);

        int length = list.size() / 2;

        int[][] res = new int[2][];

        res[0] = new int[]{1, 2};
        //res[0] = new int[]{1,2};

        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */


public class N352 {

    // todo
    @Test
    void t() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        print(summaryRanges.getIntervals()); // 返回 [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        print(summaryRanges.getIntervals()); // 返回 [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        print(summaryRanges.getIntervals()); // 返回 [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        print(summaryRanges.getIntervals()); // 返回 [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        print(summaryRanges.getIntervals()); // 返回 [[1, 3], [6, 7]]

    }

    void print(int[][] intervals) {
        if (intervals != null) {
            System.out.println("");
            for (int[] interval : intervals) {
                System.out.println(Arrays.toString(interval));
            }
        }
    }

    @Test
    void t2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 0);
        list.add(1, 1);
        list.add(1, 2);
        list.add(1, 3);

        System.out.println(list);
    }

}