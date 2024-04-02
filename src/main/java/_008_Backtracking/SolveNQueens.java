package _008_Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/n-queens/
 */
public class SolveNQueens {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    int[][] vis = new int[10][10];

    public List<List<String>> solveNQueens(int n) {
        dfs(1, n);
        return ans;
    }

    void dfs(int row, int n) {

        if (path.size() == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (vis[row][i] != 0) {
                continue;
            }

            difVis(row, i, n, 1);
            path.add(buildS(i - 1, n));
            dfs(row + 1, n);
            difVis(row, i, n, -1);
            path.remove(path.size() - 1);
        }
    }

    String buildS(int i, int n) {
        char[] chars = new char[n];
        for (int j = 0; j < n; j++) {
            chars[j] = i == j ? 'Q' : '.';
        }
        return new String(chars);
    }


    void difVis(int i, int j, int n, int v) {
        for (int k = 1; k <= n; k++) {
            if (k == i) {
                continue;
            }
            vis[k][j] += v;
        }

        int lui = i - 1, luj = j - 1;
        while (lui >= 1 && luj >= 1) {
            vis[lui][luj] += v;
            lui--;
            luj--;
        }

        int rdi = i + 1;
        int rdj = j + 1;
        while (rdi <= n && rdj <= n) {
            vis[rdi][rdj] += v;
            rdi++;
            rdj++;
        }

        int rui = i - 1;
        int ruj = j + 1;
        while (rui >= 1 && ruj <= n) {
            vis[rui][ruj] += v;
            rui--;
            ruj++;
        }

        while (i <= n && j >= 1) {
            vis[i][j] += v;
            i++;
            j--;
        }
    }

    @Test
    public void test() {
//        difVis(1,1,9,1);
//        difVis(1,1,9,-1);
//        for (int i = 1; i <= 9 ; i++) {
//            for (int j=1;j<=9;j++){
//                System.out.print(vis[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        solveNQueens(6);
    }


}
