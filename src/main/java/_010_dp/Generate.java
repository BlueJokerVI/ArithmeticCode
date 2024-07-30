package _010_dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        //dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
        List<List<Integer>> ans = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        List<Integer> x = new ArrayList<>();
        x.add(1);
        ans.add(x);
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                tmp.add(dp[i][j]);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
