package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximize-happiness-of-selected-children/
 */
public class MaximumHappinessSum {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        Arrays.sort(happiness);
        int n = happiness.length;
        int down = 0;
        for (int i = 0; i < k; i++) {
            ans += Math.max(happiness[n - 1 - i] - down, 0);
            down++;
        }
        return ans;
    }

}
