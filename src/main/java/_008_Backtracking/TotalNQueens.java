package _008_Backtracking;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/n-queens-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class TotalNQueens {


    int ans;
    int[][] vis = new int[10][10];
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        dfs(1);
        return ans;
    }

    void dfs(int index) {

        if(index == n+1){
            ans++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (vis[index][i] != 0) {
                continue;
            }
            addVis(index,i,1);
            dfs(index+1);
            addVis(index,i,-1);
        }
    }


    void addVis(int x, int y, int v) {
        for (int j = 1; j <= n; j++) {
            vis[x][j] += v;
        }
        for (int i = 1; i <= n; i++) {
            if(i==x){
                continue;
            }
            vis[i][y] += v;
        }

        int i = x+1, j = y+1;
        while (i <= n && j <= n) {
            vis[i][j] += v;
            i++;
            j++;
        }

        i = x-1;
        j = y-1;
        while (i >= 1 && j >= 1) {
            vis[i][j] += v;
            i--;
            j--;
        }

        i = x + 1;
        j = y - 1;
        while (i<=n && j>=1){
            vis[i][j] += v;
            i++;
            j--;
        }

        i = x - 1;
        j = y + 1;
        while (i>=1 && j<=n){
            vis[i][j] += v;
            i--;
            j++;
        }
    }
}
