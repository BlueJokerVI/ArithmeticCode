package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-the-number-of-fair-pairs/
 */
public class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;

        //枚举nums[j],二分查找nums[i]     lower <= nums[i] + nums[j] <= upper
        for (int j = 0; j < n; j++) {
            int l = findGx(nums, j, lower - nums[j]);
            int r = findGx(nums, j, upper - nums[j] + 1) - 1;
            ans += (r - l + 1);
        }
        return ans;
    }

    //返回第一个大于等于x的下标
    // 1 2 2 3
    private int findGx(int[] nums, int j, int x) {
        int l = 0, r = j - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }


    //3指针解法
    public long countFairPairs1(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        //枚举nums[j]       lower - nums[j] <= nums[i] <= upper - nums[j]

        int l = nums.length;
        int r = nums.length;
        long ans = 0;
        for (int j = 0; j < nums.length; j++) {

            while (l >= 0 && lower - nums[j] <= nums[l - 1]) {
                l--;
            }

            while (r >= 0 && nums[r - 1] > upper - nums[j]) {
                r--;
            }

            //j > i
            ans += Math.min(r, j) - Math.min(l, j);

        }

        return ans;
    }

    public static void main(String[] args) {
        CountFairPairs t = new CountFairPairs();
        t.countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6);
    }

}
