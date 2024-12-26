package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/partition-string-into-substrings-with-values-at-most-k/
 */
public class MinimumPartition {
    public int minimumPartition(String s, int k) {
        int ans = 0;
        char[] cs = s.toCharArray();
        long cur = 0;
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            cur = cur * 10 + cs[i] - '0';
            if (cur > k) {
                ans++;
                cur = cs[i] - '0';
                if (cur > k) {
                    return -1;
                }
            }
        }
        return ans + 1;
    }
}
