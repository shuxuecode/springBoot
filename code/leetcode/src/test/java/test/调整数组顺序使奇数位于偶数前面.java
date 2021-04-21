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
        reOrderArray(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void reOrderArray(int[] array) {

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (array[start] % 2 == 1) {
                start++;
            }
            swap1(array, start, end);

            while (array[end] % 2 == 0) {
                end--;
            }
            swap2(array, start, end);
        }

        System.out.println("start " + start);
        System.out.println("end " + end);

    }

    public void swap1(int[] array, int start, int end) {
        int i = start;
        i++;
        // 寻找下一个奇数
        while (array[i] % 2 == 1) {
            i++;
        }
        if (i < end) {
            while (i > start) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
    }

    public void swap2(int[] array, int start, int end) {
        int i = end;
        i--;
        // 寻找下一个偶数
        while (array[i] % 2 == 0) {
            i--;
        }
        if (start < i) {
            while (i < end) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                i++;
            }
        }
    }
}
