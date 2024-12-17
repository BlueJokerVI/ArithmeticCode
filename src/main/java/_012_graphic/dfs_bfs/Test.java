package _012_graphic.dfs_bfs;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] vis;

    public int numIslands(char[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || vis[x][y]) {
            return;
        }
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            dfs(dx, dy, grid);
        }
    }


    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs1(i, 0, board, 'M');
            }
            if (board[i][n - 1] == 'O') {
                dfs1(i, n - 1, board, 'M');
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs1(0, j, board, 'M');
            }
            if (board[m - 1][j] == 'O') {
                dfs1(m - 1, j, board, 'M');
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    dfs1(i, j, board, 'X');
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs1(int x, int y, char[][] board, char c) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || board[x][y] == 'M') {
            return;
        }
        board[x][y] = c;
        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            dfs1(dx, dy, board, c);
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Deque<String> q = new ArrayDeque<>();
        Map<String, Integer> mp = new HashMap<>();
        q.add(beginWord);
        mp.put(beginWord, 1);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.remove();
                int step = mp.get(cur);
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (chars[i] == j) {
                            continue;
                        }
                        char tmp = chars[i];
                        chars[i] = j;
                        String copy = String.valueOf(chars);

                        if (copy.equals(endWord)) {
                            return step + 1;
                        }

                        if (mp.containsKey(copy)) {
                            chars[i] = tmp;
                            continue;
                        }

                        if (set.contains(copy)) {
                            q.add(copy);
                            mp.put(copy, step + 1);
                        }
                        chars[i] = tmp;
                    }
                }
            }
        }

        return 0;
    }


    @org.junit.Test
    public void test() {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            mp.put(i, i + 1);
        }
        mp.forEach((k, v) -> {
           mp.remove(1);
        });

    }


}
