package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N852 {
    // 二分查找法   执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    public int peakIndexInMountainArray(int[] arr) {
        return get(arr, 0, arr.length - 1);
    }

    public int get(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            // 小于，在左半边的山脉
            return get(arr, mid, right);
        } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            // 大于，在右半边的山脉
            return get(arr, left, mid);
        } else {
            return mid;
        }
    }

    public int peakIndexInMountainArray1(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void t() {
//        int[] arr = {0, 1, 0};
//        int[] arr = {0,10,5,2};
//        int[] arr = {3,4,5,1};
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int i = peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}
