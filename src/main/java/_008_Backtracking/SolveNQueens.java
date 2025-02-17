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








    class Solve{
        List<List<String>> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();

        int n;
        int[] visRow;
        int[] visCol;
        int[] visPk;
        int[] visNk;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            visRow = new int[n];
            visCol = new int[n];
            visPk = new int[2 * n - 1];
            visNk = new int[2 * n - 1];

            solveNQueensDfs(0);
            return ans;

        }

        private void solveNQueensDfs(int index) {
            if (index == n) {
                ans.add(new ArrayList<>(tmp));
                return;
            }

            for (int j = 0; j < n; j++) {
                if (visRow[index]>0 || visCol[j]>0 || visPk[index + j]>0 || visNk[index - j + n - 1]>0) {
                    continue;
                }
                StringBuilder s = new StringBuilder();
                int i=0;
                for(;i<j;i++) s.append('.'); s.append('Q');
                for(i=j+1;i<n;i++) s.append('.');

                tmp.add(s.toString());
                visRow[index]++;visCol[j] ++; visPk[index + j] ++; visNk[index - j + n - 1]++;
                solveNQueensDfs(index+1);
                tmp.remove(tmp.size()-1);
                visRow[index]--;visCol[j] --; visPk[index + j] --; visNk[index - j + n - 1]--;
            }
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
