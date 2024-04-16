package _010_dp;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/combination-sum-iv/
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        /**
        *
        * dp[j] 得到j价值的排列次数
        * 求排列数，对于每一个容量，都会尝试放入可放入值
        */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }


    /**
     * dfs记忆化搜索，6
     */
    public int combinationSum41(int[] nums, int target) {
        int[] m = new int[target + 1];
        Arrays.fill(m, -1);
        return dfs(target, nums, m);
    }

    private int dfs(int i, int[] nums, int[] m) {

        //找0直接返回1
        if (i == 0) {
            return 1;
        }
        //非第一次访问i，直接返回记忆的m[i]
        if (m[i] != -1) {
            return m[i];
        }

        //第一次访问i
        int res = 0;
        for (int x: nums) {
            if (x <= i) {
                res += dfs(i - x, nums, m);
            }
        }

        //返回凑成i的次数
        return m[i] = res;
    }
}
