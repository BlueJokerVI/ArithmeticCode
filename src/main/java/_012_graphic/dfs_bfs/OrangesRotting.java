package _012_graphic.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=top-100-liked
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[11][11];
        int m = grid.length;
        int n = grid[0].length;
        int good = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    good++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        if (good == 0) {
            return 0;
        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (canRot(cur[0] - 1, cur[1], grid, vis, q)) {
                    good--;
                }
                if (canRot(cur[0] + 1, cur[1], grid, vis, q)) {
                    good--;
                }
                if (canRot(cur[0], cur[1] - 1, grid, vis, q)) {
                    good--;
                }
                if (canRot(cur[0], cur[1] + 1, grid, vis, q)) {
                    good--;
                }
            }
            step++;
        }

        return good == 0 ? step - 1 : -1;
    }


    boolean canRot(int x, int y, int[][] grid, boolean[][] vis, Deque<int[]> q) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= m || vis[x][y] || grid[x][y] == 2 || grid[x][y] == 0) {
            return false;
        }
        vis[x][y] = true;
        q.offer(new int[]{x, y});
        return true;
    }
}
