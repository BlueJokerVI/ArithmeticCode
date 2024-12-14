package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximize-the-total-height-of-unique-towers/
 */
public class MaximumTotalSum {
    public long maximumTotalSum(int[] maximumHeight) {
        long sum = 0;
        Arrays.sort(maximumHeight);
        int maxH = Integer.MAX_VALUE;
        int n = maximumHeight.length;
        for (int i = n - 1; i >= 0; i--) {
            if (maxH < i + 1) {
                return -1;
            }
            sum += Math.min(maxH, maximumHeight[i]);
            maxH = Math.min(maxH, maximumHeight[i]) - 1;
        }
        return sum;
    }
}
