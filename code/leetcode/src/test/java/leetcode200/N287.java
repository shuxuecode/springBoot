package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 寻找重复数
 *
 * @author zsx
 */
public class N287 {

    // 先排序，在比较
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // 可以通过
    public int findDuplicate3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // 快慢指针
    public int findDuplicate2(int[] nums) {
        // 表示的是当前的元素值
        int slow, fast;
        slow = fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    @Test
    void t() {
        int[] nums = {1, 3, 4, 2, 2};

        System.out.println(Arrays.toString(nums));

        int duplicate = findDuplicate(nums);

        System.out.println(duplicate);
    }
}
