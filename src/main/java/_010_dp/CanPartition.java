package _010_dp;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/partition-equal-subset-sum/
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int v = 0;
        for (int num : nums) {
            v += num;
        }
        if (v % 2 == 1) {
            return false;
        }
        v /= 2;

        //体积: v  第i个物品的体积和价值都为num[i]
        int[] dp = new int[v + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = v; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[v] == v;
    }


    @Test
    public void test() {
        int[] nums = new int[]{14, 9, 8, 4, 3, 2};
        canPartition(nums);
    }
}
