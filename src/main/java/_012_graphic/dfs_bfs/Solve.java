package _012_graphic.dfs_bfs;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/surrounded-regions/
 */
public class Solve {
    boolean[][] vis = new boolean[501][501];
    int ans;
    int cur;
    public void solve(char[][] board) {

        //先遍历边界上的起点
        for(int j=0;j<board[0].length;j++){
            dfs(0,j,board);
            dfs(board.length-1,j,board);
        }
        for(int i=0;i< board.length;i++){
            dfs(i,0,board);
            dfs(i,board[0].length-1,board);
        }

        //在遍历没有遍历过的点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==0 || vis[i][j]){
                    continue;
                }
                cur = 0;
                dfs1(i,j,board);
                ans += cur;
            }
        }
    }


    void dfs(int i,int j,char[][] board){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]=='X' || vis[i][j]) {
            return;
        }
        cur++;
        vis[i][j] = true;
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }


    void dfs1(int i,int j,char[][] board){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]=='X' || vis[i][j]) {
            return;
        }
        board[i][j]='X';
        cur++;
        vis[i][j] = true;
        dfs1(i+1,j,board);
        dfs1(i-1,j,board);
        dfs1(i,j+1,board);
        dfs1(i,j-1,board);
    }
}
