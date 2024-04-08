package _009_Greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShots {
    /**
     * [10,16],[2,8],[1,6],[7,12]
     * <p>
     * [1,6],[2,8],[7,12],[10,16]
     * <p>
     * <p>
     * [3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]
     * <p>
     * [0,6],[0,9],[2,8],[2,9],[3,8],[3,9],[3,9],[6,8],[7,12],[9,10]
     *
     *
     * [9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]
     *
     * [1,10],[3,9],[4,11],[6,7],[6,9],[8,12],[9,12],
     * @param points
     * @return
     */

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        int ans = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {

            if(points[i][0] <= pre){
                pre = Math.min(pre,points[i][1]);
            }else {
                ans++;
                pre = points[i][1];
            }
        }

        return ans;
    }


    @Test
    public void test() {
        int[][] nums = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        findMinArrowShots(nums);
    }


}
