package _013_binary_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cct
 * https://leetcode.cn/problems/path-with-minimum-effort/
 */
public class MinimumEffortPath {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0, 0});
            boolean[] seen = new boolean[m * n];
            seen[0] = true;
            //广度优先
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(new int[]{nx, ny});
                        seen[nx * n + ny] = true;
                    }
                }
            }
            if (seen[m * n - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int l = 0, r = 0;
            int n = heights.length;
            int m = heights[0].length;

            for (int[] height : heights) {
                for (int i : height) {
                    r = Math.max(r, i);
                }
            }

            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (check(heights, new boolean[n][m], mid, heights[0][0], 0, 0, n, m)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return r + 1;
        }

        boolean check(int[][] heights, boolean[][] vis, int mid, int pre, int x, int y, int n, int m) {

            if (x < 0 || x >= n || y < 0 || y >= m) {
                return false;
            }

            if (vis[x][y] ||  Math.abs(heights[x][y] - pre)  > mid) {
                return false;
            }

            if (x == n - 1 && y == m - 1) {
                return true;
            }

            vis[x][y] = true;
            int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] d : dir) {
                int dx = x + d[0];
                int dy = y + d[1];
                if (check(heights, vis, mid, heights[x][y], dx, dy, n, m)) {
                    return true;
                }
            }
            return false;
        }
    }



    public static void main(String[] args) {
        MinimumEffortPath t = new MinimumEffortPath();
        t.minimumEffortPath(new int[][]{{10, 8}, {10, 8}, {1, 2}, {10, 3}, {1, 3}, {6, 3}, {5, 2}});
    }
}
