package com.zsx;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {15, 8, 1, 19, 16, 9};

        sort(nums);

        System.out.println(Arrays.toString(nums));

    }


    public static void sort(int[] nums) {
        // 1、构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子节点从下到上，从右到左调整结构
            sortHeap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));
        // 2、调整堆结构+交换堆顶元素与末尾元素
        for (int j = nums.length - 1; j > 0; j--) {
            // 将堆顶元素与末尾元素进行交换
            swap(nums, 0, j);
            // 重新对堆进行调整
            sortHeap(nums, 0, j);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param nums
     * @param i
     * @param length
     */
    public static void sortHeap(int[] nums, int i, int length) {
        // 先取出当前元素
        int temp = nums[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 从i节点的左子节点开始，也就是2i+1处开始
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                // 如果左子节点小于右子节点，k指向右子节点
                k++;
            }
            if (nums[k] > temp) {
                // 如果子节点大于父节点，将子节点值赋给父节点(不用进行交换)
                nums[i] = nums[k];
                i = k;
            } else {
                // ??? why
                break;
            }
        }
        // 将temp值放到最终的位置
        nums[i] = temp;
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
