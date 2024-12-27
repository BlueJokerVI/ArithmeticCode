package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/
 */
public class MinimumRemoval {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        //preSum[i] 0~i-1的和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + beans[i];
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, preSum[i] + (preSum[n] - preSum[i + 1]) - ((long) beans[i] * (n - i - 1)));
        }
        return ans;
    }
}
