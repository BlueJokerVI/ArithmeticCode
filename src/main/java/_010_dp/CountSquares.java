package _010_dp;

/**
 * @author cct
 * https://leetcode.cn/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquares {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //dp[i+1][j+1]表示以(i,j)结尾的节点的正方形最大边长，也即以其为右下角结尾的正方型个数
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    ans += dp[i + 1][j + 1];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        CountSquares t = new CountSquares();
        t.countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        });
    }
}
