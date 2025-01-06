package _009_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 */
public class FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int ans = 1;
        int n = pairs.length;
        int l = pairs[0][1];
        for (int i = 2; i < n; i++) {
            if (pairs[i][0] > l) {
                ans++;
                l = pairs[i][1];
            }
        }

        return ans;

    }
}
