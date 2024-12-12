package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-ice-cream-bars/
 */
public class MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int v : costs) {
            if (coins >= v) {
                coins -= v;
                ans++;
            } else {
                return ans;
            }
        }
        return ans;
    }


    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            int[] freq = new int[100001];
            for (int cost : costs) {
                freq[cost]++;
            }
            int count = 0;
            for (int i = 1; i <= 100000; i++) {
                if (coins >= i) {
                    int curCount = Math.min(freq[i], coins / i);
                    count += curCount;
                    coins -= i * curCount;
                } else {
                    break;
                }
            }
            return count;
        }
    }
}
