package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * @author shuxuezhao
 * @date 2021/9/30
 */
public class N223 {


    // todo
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        //求两个矩形  x  轴方向相交的长度
        int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        //求两个矩形  y  轴方向相交的长度
        int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        //两个矩形 的面积和 - 相交的面积
        return (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1) - (x * y);
    }


    @Test
    void t() {
        int ax1 = -3;
        int ay1 = 0;
        int ax2 = 3;
        int ay2 = 4;
        int bx1 = 0;
        int by1 = -1;
        int bx2 = 9;
        int by2 = 2;

        int area = computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);

        System.out.println(area);
    }
}
