package _012_graphic;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/island-perimeter/
 */
public class IslandPerimeter {
    int ans;
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] vis = new boolean[101][101];
    public int islandPerimeter(int[][] grid) {
        int i,j = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    dfs(i,j,grid);
                    return ans;
                }
            }
        }
//        dfs(i,j,grid);
        return ans;
    }

    void dfs(int x,int y ,int[][] grid) {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || vis[x][y] || grid[x][y]==0) {
            return;
        }
        vis[x][y] = true;
        for (int[] ints : dir) {
            int dx =x + ints[0];
            int dy =y + ints[1];
            if(dx<0 || dx>=grid.length || dy<0 || dy>=grid[0].length ||  grid[dx][dy]==0){
                ans++;
            }
            dfs(dx,dy,grid);
        }
    }
}
