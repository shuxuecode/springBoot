package leetcode200;

import org.junit.jupiter.api.Test;

public class N215 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 4;
        int num = findKthLargest(nums, k);
        System.out.println(num);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int num = quickSort2(nums, 0, n - 1, n - k);
        return num;
    }

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
            return quickSort2(nums, left + 1, high, k);
        } else {
            return quickSort2(nums, low, right - 1, k);
        }
    }

    @Test
    public void test2() {
        int[] nums = {2, 1, 5, 4, 3};

        quickSort(nums, 0, nums.length - 1);

        System.out.println(nums);
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

}
