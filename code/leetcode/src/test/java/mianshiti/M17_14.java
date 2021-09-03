package mianshiti;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * @author zsx
 * @date 2021/9/3
 */
public class M17_14 {

    public int[] smallestK1(int[] arr, int k) {
        int[] res = new int[k];

        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }


    // todo 快排
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];

        return res;
    }

    private void qsort(int[] arr, int left, int right, int k) {
        if (left > right) return;
        int i = left, j = right;


    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    void t() {

        int[] res = smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);

        System.out.println(Arrays.toString(res));

    }
}
