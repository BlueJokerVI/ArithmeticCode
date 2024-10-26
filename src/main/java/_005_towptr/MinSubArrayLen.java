package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        //(l,r]
        int l = -1, r = 0;
        int len = Integer.MAX_VALUE;
        while (l < r && r < nums.length) {
            int subVal = l >= 0 ? preSum[r] - preSum[l] : preSum[r];

            if (subVal < target) {
                r++;
            } else {
                int tmp = (r - l);
                if (tmp < len) {
                    len = tmp;
                }
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    //滑动窗口
    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int cur = 0;
        int min = Integer.MAX_VALUE;
        int l = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            while (cur >= target) {
                if (i - l + 1 < min) {
                    min = i - l + 1;
                }
                cur -= nums[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
