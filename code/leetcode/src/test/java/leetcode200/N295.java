package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.*;

public class N295 {

    @Test
    void t() {

        long start = System.currentTimeMillis();

        MedianFinder obj = new MedianFinder();

        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);
        obj.addNum(2);

        double median = obj.findMedian();

        System.out.println(median);

        obj.addNum(3);

        median = obj.findMedian();

        System.out.println(median);

        System.out.println(System.currentTimeMillis() - start);

    }
}


class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> (b - a));
        max = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (max.size() + 1 < min.size()) {
                max.offer(min.poll());
            }
        } else {
            max.offer(num);
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
        }
    }

    public double findMedian() {
        if (min.size() > max.size()) {
            return min.peek();
        }
        return (min.peek() + max.peek()) / 2.0;
    }
}


// 下面这些方法都是超出时间限制了
class MedianFinder2 {

    //    List<Integer> list;
    int[] nums;

    /**
     * initialize your data structure here.
     */
    public MedianFinder2() {
//        list = new ArrayList<>();
        nums = new int[]{};
    }

//    public void addNum(int num) {
//        list.add(num);
//    }

//    public double findMedian() {
//        int size = list.size();
//        if (size == 0) {
//            return 0;
//        }
//        Collections.sort(list);
//        // 偶数
//        if (size % 2 == 0) {
//            int i = size / 2;
//            int sum = list.get(i) + list.get(i - 1);
//            return sum / 2d;
//        } else {
//            return list.get(size / 2);
//        }
//    }

    public void addNum(int num) {
        int length = nums.length;
        if (length == 0) {
            nums = new int[]{num};
            return;
        }
        // 第一种，插入时排序
//        int len = nums.length + 1;
//        int[] array = new int[len];
//        int n = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (n == len - 1) {
//                array[i] = num;
//                continue;
//            }
//            array[i] = nums[n] < num ? nums[n++] : num;
//        }
//        nums = array;

        // 第二种，查询时再排序
        int[] array = new int[length + 1];
        for (int i = 0; i < length; i++) {
            array[i] = nums[i];
        }
        array[length] = num;
        nums = array;
    }


    public double findMedian() {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        // 偶数
        if (length % 2 == 0) {
            int i = length / 2;
            int sum = nums[i] + nums[i - 1];
            return sum / 2d;
        } else {
            return nums[length / 2];
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */