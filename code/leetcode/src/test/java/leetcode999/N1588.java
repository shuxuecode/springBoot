package leetcode999;

import org.junit.jupiter.api.Test;

public class N1588 {

    /**
     * 暴力解法，把所有的子数组全部遍历出来并计算和
     * <p>
     * 性能不高
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;

        int n = 1;

        while (n <= arr.length) {

            for (int i = 0; i < arr.length; i++) {

                if (i + n <= arr.length) {
                    for (int j = i; j < i + n; j++) {
                        sum += arr[j];
                    }
                }

            }

            n += 2;
        }

        return sum;
    }


    // 计算出从每个元素出发的子数组的和，可以利用之前计算好的和
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            // 记录前边几个数字的和
            int temp = arr[i];
            sum += temp;

            for (int j = i + 2; j < length; j += 2) {
                temp += arr[j - 1] + arr[j];
                sum += temp;
            }
        }
        return sum;
    }

    @Test
    void t() {
        int[] arr = {10, 11, 12};
//        int[] arr = {1, 4, 2, 5, 3};

        int sum = sumOddLengthSubarrays(arr);

        System.out.println(sum);
    }
}
