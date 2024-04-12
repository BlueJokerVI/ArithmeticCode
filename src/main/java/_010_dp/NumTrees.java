package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class NumTrees {

    /**
     *
     *      1                                            0
     *
     * 1         2                                       1
     *   2     1
     *
     * 1             2        3        3                 2
     *   2          1       1        2
     *      3     3            2    1
     *
     *
     * dp[i]表示i个节点有dp[i]种二叉搜索树
     *
     *  i+1做头节点   i+1做叶子节点    i+1做非头非叶节点（i-j ,j）
     * dp[i+1] = dp[i]*2  + 非头非叶节点;
     *
     *
     * 最终递推关系   dp[i] = dp[i-1-j] + dp[j]   枚举j
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;


        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
}
