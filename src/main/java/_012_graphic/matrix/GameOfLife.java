package _012_graphic.matrix;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/game-of-life/?envType=study-plan-v2&envId=top-interview-150
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        // 0 1   -1:0->1活   -2:1->0死
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getStatus(i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getV(board[i][j]);
            }
        }

    }


    int getV(int v) {
        if (v == 0 || v == 1) {
            return v;
        } else if (v == -1) {
            return 1;
        } else {
            return 0;
        }
    }

    int getO(int v) {
        if (v == 0 || v == 1) {
            return v;
        } else if (v == -1) {
            return 0;
        } else {
            return 1;
        }
    }

    int getStatus(int dx, int dy, int[][] board) {
        int live = 0;

        int x = dx - 1;
        int y = dy - 1;
        for (; y <= dy + 1; y++) {
            if (canGo(x, y, board)) {
                if (getO(board[x][y]) == 1) {
                    live++;
                }
            }
        }

        x = dx + 1;
        y = dy - 1;
        for (; y <= dy + 1; y++) {
            if (canGo(x, y, board)) {
                if (getO(board[x][y]) == 1) {
                    live++;
                }
            }
        }

        x = dx;
        y = dy - 1;
        if (canGo(x, y, board)) {
            if (getO(board[x][y]) == 1) {
                live++;
            }
        }

        y = dy + 1;
        if (canGo(x, y, board)) {
            if (getO(board[x][y]) == 1) {
                live++;
            }
        }

        if (live < 2 || live > 3) {
            if (getO(board[dx][dy]) == 1) {
                return -2;
            }
        }

        if (live == 3) {
            if (getO(board[dx][dy]) == 0) {
                return -1;
            }
        }

        return board[dx][dy];

    }

    boolean canGo(int x, int y, int[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }


    //写的优雅点o.0
    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length;       // 行数
            int n = board[0].length;    // 列数
            int count = 0;              // 统计每个格子周围八个位置的活细胞数
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    count = 0;      // 每个格子计数重置为0
                    for(int x = -1; x <= 1; x++){
                        for(int y = -1; y <= 1; y++){
                            // 枚举周围八个位置，其中去掉本身（x = y = 0）和越界的情况
                            if((x == 0 && y == 0) || i + x < 0 || i + x >= m || j + y < 0 || j + y >= n)continue;
                            // 如果周围格子是活细胞（1）或者是活细胞变死细胞（2）的，都算一个活细胞
                            if(board[i + x][j + y] == 1 || board[i + x][j + y] == 2)count++;
                        }
                    }
                    if(board[i][j] == 1 && (count < 2 || count > 3))board[i][j] = 2;    // 格子本身是活细胞，周围满足变成死细胞的条件，标记为2
                    if(board[i][j] == 0 && count == 3)board[i][j] = 3;      // 格子本身是死细胞，周围满足复活条件，标记为3
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    // 死细胞为0，活细胞变成死细胞为2，都为偶数，模2为0，刚好是死细胞
                    // 活细胞为1，死细胞变成活细胞为3，都为奇数，模2为1，刚好是活细胞
                    board[i][j] %= 2;
                }
            }

        }
    }



    @Test
    public void test() {
        gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}
