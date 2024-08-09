package _017_math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/rectangle-area/
 */
public class ComputeArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - repeatedArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }



    //计算重叠部分面积
    private int repeatedArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if(bx2 <= ax1 || bx1 >= ax2 || by1>=ay2 || by2<=ay1){
            return 0;
        }

        int[] x = new int[]{ax1,ax2,bx1,bx2};
        int[] y = new int[]{ay1,ay2,by1,by2};

        Arrays.sort(x);
        Arrays.sort(y);


        System.out.println();
        return (x[2]-x[1])*(y[2]-y[1]);
    }


    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int area1=(ax2-ax1)*(ay2-ay1),area2=(bx2-bx1)*(by2-by1);
            int overlapWidth=Math.min(ax2,bx2)-Math.max(ax1,bx1);
            int overlapHeight=Math.min(ay2,by2)-Math.max(ay1,by1);
            int overArea=Math.max(overlapHeight,0)*Math.max(overlapWidth,0);
            return area1+area2-overArea;
        }
    }

    @Test
    public void test(){
        computeArea(-3,0,3,4,0,-1,9,2);
    }
}
