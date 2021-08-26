package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int res = 0;

        int left = 0;
        int right = people.length - 1;

        while (left < right) {

            if (people[left] + people[right] > limit) {
                res++;
                right--;
                continue;
            }

            left++;
            right--;

            res++;
        }

        if (left == right) {
            res++;
        }

        return res;
    }

    // 这种没有限制每条船只能坐2人
    public int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people);

        int res = 0;

        int left = 0;
        int right = people.length - 1;

        while (left < right) {

            if (people[left] + people[right] > limit) {
                res++;
                right--;
                continue;
            }

            int i = left;
            int sum = people[i] + people[right];
            while (sum <= limit && i < right) {
                i++;
                sum += people[i];
                left = i;
            }

            res++;
            right--;
        }

        if (left == right) {
            res++;
        }

        return res;
    }

    @Test
    void t() {
        int[] people = {3, 2, 2, 1};
        people = new int[]{3, 5, 3, 4};
        int limit = 5;

//        int i = numRescueBoats(people, limit);


//        int i = numRescueBoats(new int[]{2, 2}, 6);
        int i = numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50);

        System.out.println(i);
    }
}
