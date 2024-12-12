package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/
 */
public class MaximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(dif);
        int ans = 0;
        for (int v : dif) {
            if (additionalRocks >= v) {
                additionalRocks -= v;
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
}
