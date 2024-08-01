package _010_dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public int uniquePaths(int m, int n) {

        //dp[i][j] 从[0][0]到[i-1][j-1]共有多少条路径
        //dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pre = Math.min(i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE, j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE);
                dp[i][j] = pre == Integer.MAX_VALUE ? 0 : pre + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }


    public String longestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int ans = 1;
        String ansS = String.valueOf(cs[0]);
        //dp[i][j]标记[i,j]子串是否是回文串
        //if cs[i]==cs[j] : dp[i][j] = dp[i+1][j-1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1 && cs[i] == cs[j]) {
                    dp[i][j] = true;
                    if (j - i + 1 > ans) {
                        ans = j - i + 1;
                        ansS = s.substring(i, j + 1);
                    }
                    continue;
                }

                if (cs[i] == cs[j] && dp[i + 1][j - 1]) {
                    if (j - i + 1 > ans) {
                        ans = j - i + 1;
                        ansS = s.substring(i, j + 1);
                    }
                    dp[i][j] = true;
                }

            }

        }
        return ansS;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();
        //dp[i][j]表示cs1[0~i-1] 与 cs2[0~i-1]的最长公共子序列长度
        //if cs[i]==cs[j] : dp[i][j] = max(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]) + 1
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i][j - 1], dp[i - 1][j]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[m][n];
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        //dp[i][j] 表示[0~i-1] 到 [0~j-1]需要的最少操作数
        //if cs1[i]==cs2[j] : dp[i][j] = dp[i-1][j-1]
        //if cs1[i]!=cs2[j] : dp[i][j] = dp[i-1][j-1] + 1

        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(cs1[i-1]==cs2[j-1]){
                    dp[i][j] =  dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }


    @Test
    public void test() {
        minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }
}
