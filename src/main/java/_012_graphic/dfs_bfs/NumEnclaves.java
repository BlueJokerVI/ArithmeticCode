package _012_graphic.dfs_bfs;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-enclaves/
 */
public class NumEnclaves {

    boolean[][] vis = new boolean[501][501];
    int ans;
    int cur;
    public int numEnclaves(int[][] grid) {

        //先遍历边界上的起点
        for(int j=0;j<grid[0].length;j++){
            dfs(0,j,grid);
            dfs(grid.length-1,j,grid);
        }
        for(int i=0;i< grid.length;i++){
            dfs(i,0,grid);
            dfs(i,grid[0].length-1,grid);
        }

        //在遍历没有遍历过的点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==0 || vis[i][j]){
                    continue;
                }
                cur = 0;
                dfs(i,j,grid);
                ans += cur;
            }
        }

        return ans;
    }


    void dfs(int i,int j,int[][] grid){
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
