package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-product-subarray/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        //maxF[i] 以i结尾可得的最大值
        //minF[i] 以i结尾可得的最小值
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);
        for (int i = 1; i < n; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}
