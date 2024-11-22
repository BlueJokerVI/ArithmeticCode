package _013_binary_search;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-absolute-sum-difference/
 */
public class MinAbsoluteSumDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dif = new int[n];
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int v = Math.abs(nums1[i] - nums2[i]);
            dif[i] = v;
            sum = (sum + v) % mod;
        }
        int bigDec = Integer.MIN_VALUE;
        Arrays.sort(nums1);

        //枚举差值
        for (int i = 0; i < n; i++) {
            int v = dif[i];
            int t = nums2[i];

            int l = findGe(nums1, t);
            l = l == n ? n - 1 : l;
            int r = findGe(nums1, t + 1) - 1;
            r = r<0 ? r= 0 : r;
            int curMin = Math.min(Math.abs(t - nums1[l]), Math.abs(t - nums1[r]));
            if (v - curMin > bigDec) {
                bigDec = v - curMin;
            }
        }
        return sum - bigDec < 0 ? sum + mod - bigDec : sum - bigDec;
    }


    private int findGe(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        MinAbsoluteSumDiff t = new MinAbsoluteSumDiff();
        t.minAbsoluteSumDiff(new int[]{1,7,5},new int[]{2,3,5});
    }
}
