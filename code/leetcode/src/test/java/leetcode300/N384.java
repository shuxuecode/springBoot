package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author zsx
 * @date 2021年06月21日 17:06
 */
public class N384 {

    int[] nums;
    Random random;

    public N384(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {

        int length = nums.length;

        ArrayList<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(nums[i]);
        }


        int[] res = new int[length];
        int i = 0;
        while (list.size() > 0) {
            int index = random.nextInt(list.size());
            res[i] = list.get(index);
            i++;
            list.remove(index);
        }

        return res;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        N384 n384 = new N384(nums);

        int[] reset = n384.reset();

        System.out.println(Arrays.toString(reset));

        int[] shuffle = n384.shuffle();
        System.out.println(Arrays.toString(shuffle));

    }
}
