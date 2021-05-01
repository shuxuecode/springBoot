package leetcode;

import org.junit.jupiter.api.Test;

public class N80 {

    public int removeDuplicates(int[] nums) {

        int num = nums[0];
        int i = 1;
        int j = 1;

        int m = 1;

        while (j < nums.length) {
            if (nums[j] == num) {
                if (m == 2) {
                    // 需要移动元素
                    System.out.println("需要移动" + nums[i]);
                    while (j < nums.length && nums[j] == num) {
                        j++;
                    }
//                    防止坐标越界
                    if (j >= nums.length) {
                        break;
                    }
                    nums[i] = nums[j];
                    m = 1;

                    num = nums[i];
                    j++;
                    i++;
                } else {
                    m = 2;
                    nums[i] = nums[j];
                    num = nums[j];
                    j++;
                    i++;
                }
            } else {
                // 不相等
                m = 1;
                nums[i] = nums[j];
                num = nums[j];
                j++;
                i++;
            }
        }
        return i;
    }


    @Test
    public void test() {
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int[] nums = {0, 0, 1, 1, 2, 3, 3};
        int[] nums = {1, 1, 1};

        int i = removeDuplicates(nums);
        print(nums);
        System.out.println(i);
    }

    public void print(int[] nums) {
        System.out.println("长度： " + nums.length);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" , ");
        }
        System.out.println();
    }
}
