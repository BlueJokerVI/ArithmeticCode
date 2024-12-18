package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 */
public class MinimumCost {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return ans + min1 + min2;
    }


    //https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/
    public int minimumCost1(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int n = cost.length;
        int t = 0;
        for (int i = n - 1; i >= 0; i--) {
            t++;
            if (t == 3) {
                t = 0;
            } else {
                ans += cost[i];
            }
        }
        return ans;
    }
}
