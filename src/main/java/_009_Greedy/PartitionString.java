package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/optimal-partition-of-string/
 */
public class PartitionString {
    public int partitionString(String s) {
        char[] cs = s.toCharArray();
        int[] exist = new int[26];
        int ans = 0;
        for (char c : cs) {
            if (exist[c-'a'] == 0) {
                exist[c-'a'] = 1;
            } else {
                ans++;
                Arrays.fill(exist, 0);
                exist[c-'a'] = 1;
            }
        }

        return ans + 1;
    }
}
