package _008_Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test1 {

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

    @Test
    public void test() {
        solveNQueens(4);
    }
}
