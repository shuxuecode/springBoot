package leetcode100;

import org.junit.jupiter.api.Test;

/**
 * @author zsx
 */
public class N149 {


    public int maxPoints(int[][] points) {
        int length = points.length;
        if (length < 3) {
            // 点数不够
            return length;
        }
        // 默认是2个点
        int maxNum = 2;

        // 遍历
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {

                int count = 2;
                // 拿到两个点的斜率
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                for (int k = j + 1; k < length; k++) {

                    // 再跟其它的点的斜率进行比较，
                    // 下面的等式相当于
                    // (points[i][0] - points[j][0]) / (points[i][1] - points[j][1]) 跟
                    // (points[i][0] - points[k][0]) / (points[i][1] - points[k][1]) 比较相等
                    if (x * (points[i][1] - points[k][1]) == y * (points[i][0] - points[k][0])) {
                        // 相等则++
                        count++;
                    }
                }

                maxNum = Math.max(maxNum, count);

                if (maxNum > length / 2) {
                    //
                    return maxNum;
                }
            }
        }
        return maxNum;
    }


    @Test
    void t() {

        int[][] points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};

        int maxPoints = maxPoints(points);

        System.out.println(maxPoints);


    }

}
