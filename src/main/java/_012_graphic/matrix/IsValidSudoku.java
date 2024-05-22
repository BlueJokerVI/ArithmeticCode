package _012_graphic.matrix;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/valid-sudoku/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVis = new boolean[board.length][board.length+1];
        boolean[][] colVis  = new boolean[board.length][board.length+1];

        for (int t = 0; t < 3; t++) {
            for (int m = 0; m < 3; m++) {
                boolean[] vis = new boolean[10];
                for (int i = t * 3; i < t * 3 + 3; i++) {
                    for (int j = m * 3; j < m * 3 + 3; j++) {
                        int c = board[i][j] - '0';
                        if(board[i][j]!='.'){
                            if(vis[c] || rowVis[i][c] || colVis[j][c]){
                                return false;
                            }
                            vis[c] = true;
                            rowVis[i][c] = true;
                            colVis[j][c] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println('9'-'0');
    }

}
