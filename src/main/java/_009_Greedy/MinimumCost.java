package _009_Greedy;

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
}
