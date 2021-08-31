package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N1109 {

    // 通过，但仅击败了28%
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            for (int i = first - 1; i < last; i++) {
                res[i] += seats;
            }
        }

        return res;
    }

    @Test
    void t() {
        int[] a = {1, 2, 10};
        int[] b = {2, 3, 20};
        int[] c = {2, 5, 25};

        int[][] bookings = {a, b, c};

        int n = 5;


        int[] res = corpFlightBookings(bookings, n);

        System.out.println(Arrays.toString(res));

//        answer = [10,55,45,25,25]
        //answer = [10,55,45,25,25]

    }
}
