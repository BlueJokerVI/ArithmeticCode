package _012_graphic.dfs_bfs;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    int ans;
    int cur;
    boolean[][] vis = new boolean[51][51];
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==0 || vis[i][j]){
                    continue;
                }
                cur = 0;
                dfs(i,j,grid);
                if(ans>cur){
                    ans = cur;
                }
            }
        }
        return ans;
    }

    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]==0 || vis[i][j]) {
            return;
        }
        cur++;
        vis[i][j] = true;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }

}
