package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/k-radius-subarray-averages/
 */
public class GetAverages {
    public int[] getAverages(int[] nums, int k) {
        int len = 2 * k + 1;
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int l = 0;
        long sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            if (r - l + 1 == len + 1) {
                sum -= nums[l];
                l++;
            }
            //1 1 1
            if (r - l + 1 == len) {
                ans[l + len / 2] = (int)(sum / len);
            }
        }
        return ans;
    }
}
