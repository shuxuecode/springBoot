package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zsx
 */
public class N260 {

    // 可以通过，但效率很低
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int i = 0;
        for (Integer integer : set) {
            res[i++] = integer;
        }

        return res;
    }


    @Test
    void t() {
        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] singleNumber = singleNumber(nums);


        System.out.println(Arrays.toString(singleNumber));

    }

}
