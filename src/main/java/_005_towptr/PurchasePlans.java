package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/4xy4Wx/
 */
public class PurchasePlans {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        long ans = 0;
        int mod = 1000000007;
        while (l < r) {
            if (nums[l] + nums[r] <= target) {
                ans = (ans + r - l) % mod;
                l++;
            } else {
                r--;
            }
        }
        return (int) ans;
    }
}
