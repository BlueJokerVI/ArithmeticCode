package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/subarray-product-less-than-k/
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int n = nums.length;
        long cur = 1;
        int l = 0;
        int ans = 0;
        //枚举左端点写法
//        for (int i = 0; i < n; i++) {
//            cur *= nums[i];
//            while (cur >= k) {
//                ans += i - l;
//                cur /= nums[l];
//                l++;
//            }
//        }
//
//        while (l < n && cur < k){
//            cur += n - l;
//            l++;
//        }

        //枚举滑动窗口右端点
        for (int i = 0; i < n; i++) {
            cur *= nums[i];
            while (l <= i && cur >= k) {
                cur /= nums[l];
                l++;
            }
            ans += i - l + 1;
        }

        return ans;
    }
}
