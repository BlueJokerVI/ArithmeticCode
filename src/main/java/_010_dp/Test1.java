package _010_dp;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test1 {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        //dp[i][0]在[0,i]取i时可得的最大金额
        //dp[i][1]在[0,i]不取i时可得的最大金额
        //dp[i][0] = dp[i-1][1] + nums[i]
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0])

        int n = nums.length;
        int[][] dp = new int[n][n];
        dp[0][0] = nums[0];
        dp[0][1] = 0;


        for (int i = 2; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


    public int numSquares(int n) {
        //dp[i] 表示凑成i需要的最少完全平方和数
        //dp[i] = min(dp[i-1]+1,dp[i-4]+1,dp[i-9]+1,dp[i-16]+1,......)

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int v = dp[i - j * j] + 1;
                dp[i] = dp[i] == 0 ? v : Math.min(dp[i], v);
            }
        }
        return dp[n];
    }


    public int coinChange(int[] coins, int amount) {

        //dp[j]  表示0~i每硬币凑成j价值的背包需要的最少硬币数
        //dp[j] = min(dp[j],dp[j-coins[i]]+1)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {

                //诺使用i号硬币时，j-coins[i]背包凑不满直接跳过
                if (dp[j - coins[i]] != -1) {
                    if (dp[j] == -1) {
                        //第一次找到符合的组成直接赋值
                        dp[j] = dp[j - coins[i]] + 1;
                        continue;
                    }
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount];
    }


    Set<String> set;
    String s;
    boolean[] mem;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        this.s = s;
        mem = new boolean[s.length()];
        return dfs(0);

    }

    private boolean dfs(int index) {
        if (index >= s.length()) {
            return true;
        }
        if (mem[index]) {
            return false;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);
            if (set.contains(cur) && dfs(i)) {
                return true;
            }
        }
        mem[index] = true;
        return false;
    }


    public int lengthOfLIS(int[] nums) {
        //dp[i]表示[0,i]且包含i的最长递增子序列
        //dp[i] = nums[i]>nums[j] ? dp[j]+1:1
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }





    @Test
    public void test() {
        /**
         * s =
         * ""
         * wordDict =
         * ["aaaa","aaa"]
         */
        List<String> strings = new ArrayList<>();
        strings.add("aaaa");
        strings.add("aaa");
        wordBreak("aaaaaaa", strings);
    }
}
