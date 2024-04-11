package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/unique-paths-ii/
 */
class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1){

                    //排除起点就是障碍的情况
                    if(obstacleGrid[i-1][j-1]==1){
                        continue;
                    }
                    //初始化节点
                    dp[1][1] = 1;
                    continue;
                }
                dp[i][j] = obstacleGrid[i-1][j-1]==1 ? 0 : dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}