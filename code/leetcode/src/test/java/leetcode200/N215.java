package leetcode200;

import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class N215 {

    @Test
    public void test() {
        int[] nums = {6, 8, 1, 2, 3, 4, 5};
        int k = 4;
        int num = findKthLargest(nums, k);
        System.out.println(num);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int num = quickSort2(nums, 0, n - 1, n - k);
//        int num = priority(nums, k);
        return num;
    }

    /**
     * @param nums
     * @param low
     * @param high
     * @param k    记录第几大的数据所在的下标
     * @return
     */
    public int quickSort2(int[] nums, int low, int high, int k) {
        int temp = nums[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = temp;

        if (left == k) {
            return nums[left];
        } else if (left < k) {
            // 中间坐标小于目标坐标，则查询右边的一半
            return quickSort2(nums, left + 1, high, k);
        } else {
            return quickSort2(nums, low, left - 1, k);
        }
    }

    // 小顶堆
    public int priority(int[] nums, int k) {
        // 维护一个优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }

        return priorityQueue.poll();
    }

    @Test
    public void test2() {
        int[] nums = {2, 1, 5, 4, 3};

//        quickSort(nums, 0, nums.length - 1);
        quickSort3(nums, 0, nums.length - 1);

        System.out.println();
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void quickSort(int[] nums, int low, int high) {
        int mid;
        if (low < high) {
            mid = getMiddle(nums, low, high);

            print(nums);
            System.out.println("中位数为： " + nums[mid]);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

    public int getMiddle(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }


    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i == array.length - 1) {
                System.out.println();
            } else {
                System.out.print(" , ");
            }
        }
    }


    public void quickSort3(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int temp = nums[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;

        quickSort3(nums, left + 1, high);
        quickSort3(nums, low, left - 1);
    }
}
