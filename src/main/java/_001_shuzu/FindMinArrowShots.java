package _001_shuzu;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] > o2[0] ? 1 : -1;
            } else {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        int ans = 1;
        int r = points[0][1];
        for (int i = 1; i < points.length; i++) {

            if(points[i][0] > r){
                ans++;
                r = points[i][1];
            }else {
                r = Math.min(r,points[i][1]);
            }
        }

        return ans;
    }

    @Test
    public void test() {
        findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
    }
}
