package test;

import org.junit.jupiter.api.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {

    /*
    {1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10}
    {1, 3, 2, 4, 5, 6, 12, 7, 8, 9, 10}
    {1, 3, 2, 4, 5, 6, 12, 7, 8, 9, 10}
     */

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10};
//        int[] arr = {1, 2, 3, 4};
//        reOrderArray(arr);
        reOrderArray2(arr);

        for (int i : arr) {
            System.out.print(i);
            System.out.print(" , ");
        }
    }

    public void reOrderArray(int[] array) {

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (start < end && array[start] % 2 == 1) {
                // 奇数跳过
                start++;
            }
            if (start >= end) {
                break;
            }
            // start 表示当前偶数的坐标，需要寻找下一个奇数的坐标
            int tmp = start + 1;
            while (tmp < end && array[tmp] % 2 == 0) {
                // 偶数跳过
                tmp++;
            }
            if (tmp >= end) {
                break;
            }
            // tmp 表示奇数的坐标
            // 此时需要，从tmp坐标依次跟前一个元素进行交换，最后到start坐标为止

            for (int i = tmp; i > start; i--) {
                swap(array, i - 1, i);
            }
            //
//            start = tmp;

//            while (array[end] % 2 == 0) {
//                end--;
//            }
//            swap2(array, start, end);
        }

        System.out.println("start " + start);
        System.out.println("end " + end);

    }

    public void reOrderArray2(int[] array) {

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (start < end && array[start] % 2 == 1) {
                // 奇数跳过
                start++;
            }
            if (start >= end) {
                break;
            }
            // start 表示当前偶数的坐标，需要寻找下一个奇数的坐标
            int m = start + 1;
            while (m < end && array[m] % 2 == 0) {
                // 偶数跳过
                m++;
            }
            // m 表示奇数的坐标
            // 此时需要，从 m 坐标依次跟前一个元素进行交换，最后到start坐标为止
            for (int i = m; i > start; i--) {
                swap(array, i - 1, i);
            }

//            while (array[end] % 2 == 0) {
//                end--;
//            }
//            swap2(array, start, end);
            while (start < end && array[end] % 2 == 0) {
                // 偶数跳过
                end--;
            }
            if (start >= end) {
                break;
            }
            // end 表示当前奇数的坐标，需要寻找下一个偶数的坐标
            int n = end - 1;
            while (n > end && array[n] % 2 == 1) {
                // 奇数跳过
                n--;
            }
            if (n <= start) {
                break;
            }
            // n 表示偶数的坐标
            // 此时需要，从 n 坐标依次跟后一个元素进行交换，最后到 end 坐标为止
            for (int i = n; i < end; i++) {
                swap(array, i, i + 1);
            }
        }

        System.out.println("start " + start);
        System.out.println("end " + end);
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
