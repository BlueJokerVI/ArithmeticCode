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



    class Solution {
        public boolean canPartition(int[] nums) {
            int s = 0;
            for (int num : nums) {
                s += num;
            }
            if (s % 2 != 0) {
                return false;
            }
            int n = nums.length;
            int[][] memo = new int[n][s / 2 + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1); // -1 表示没有计算过
            }
            return dfs(n - 1, s / 2, nums, memo);
        }

        //计算0~i能否求得何为j的子序列
        private boolean dfs(int i, int j, int[] nums, int[][] memo) {
            if (i < 0) {
                return j == 0;
            }
            if (memo[i][j] != -1) { // 之前计算过
                return memo[i][j] == 1;
            }
            boolean res = j >= nums[i] && dfs(i - 1, j - nums[i], nums, memo) || dfs(i - 1, j, nums, memo);
            memo[i][j] = res ? 1 : 0; // 记忆化
            return res;
        }


        public boolean canPartition1(int[] nums) {
            int s = 0;
            for (int num : nums) {
                s += num;
            }
            if (s % 2 != 0) {
                return false;
            }
            s/=2;
            int n = nums.length;

            //f[i][j] 表示在[0~i-1]能否找到和为j的值
            //f[i][j] = nums[i] <= j && f[i-1][j-nums[i]] || f[i-1][j]
            boolean[][] f = new boolean[n+1][s+1];
            f[0][0] = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<=s;j++){
                    f[i+1][j] = nums[i] <= j && f[i][j-nums[i]] || f[i][j];
                }
            }

            return f[n+1][s];
        }
    }


    @Test
    public void test() {
        int[] nums = new int[]{14, 9, 8, 4, 3, 2};
        canPartition(nums);
    }
}
