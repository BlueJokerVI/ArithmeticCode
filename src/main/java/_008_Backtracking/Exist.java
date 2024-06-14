package _008_Backtracking;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/word-search/?envType=study-plan-v2&envId=top-interview-150
 */
public class Exist {

    char[] chs;
    boolean[][] vis = new boolean[7][7];
    char[][] mp;
    int n, m;

    public boolean exist(char[][] board, String word) {
        chs = word.toCharArray();
        mp = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int x, int y, int index) {
        if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || chs[index] != mp[x][y]) {
            return false;
        }

        if(index==chs.length-1){
            return true;
        }


        vis[x][y] = true;
        boolean f;
        f = dfs(x + 1, y, index + 1) ||
                dfs(x - 1, y, index + 1) ||
                dfs(x, y + 1, index + 1) ||
                dfs(x, y - 1, index + 1);
        vis[x][y] = false;
        return f;
    }
}
