package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/apple-redistribution-into-boxes/
 */
public class MinimumBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int m = capacity.length;
        int n = apple.length;
        int index = 0;
        int ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            while (index < m && capacity[i] >= apple[index]) {
                capacity[i] -= apple[index++];
            }
            if (index == m) {
                ans = m - 1 - i + 1;
                break;
            } else {
                apple[index] -= capacity[i];
            }
        }
        return ans;
    }
}
