package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 */
public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] boxType : boxTypes) {
            int t = Math.min(boxType[0], truckSize);

            ans += t * boxType[1];
            truckSize -= t;
            if (truckSize == 0) {
                break;
            }
        }
        return ans;
    }
}
