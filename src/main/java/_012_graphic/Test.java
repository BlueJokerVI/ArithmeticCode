package _012_graphic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {

    boolean[][] numIslandsVis = new boolean[301][301];
    char[][] grid;
    int m, n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!numIslandsVis[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0' || numIslandsVis[x][y]) {
            return;
        }

        numIslandsVis[x][y] = true;
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);

    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] mp = new boolean[numCourses][numCourses];
        int[] in = new int[numCourses];
        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            mp[pre[1]][pre[0]] = true;
        }

        Deque<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.offer(i);
                cnt++;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < numCourses; i++) {
                if (mp[cur][i]) {
                    mp[cur][i] = false;
                    in[i]--;
                    if (in[i] == 0) {
                        cnt++;
                        q.offer(i);
                    }
                }
            }
        }
        return cnt == numCourses;
    }


    class Trie {

        Node head;

        class Node {
            public Node(char cur, boolean isEnd) {
                this.cur = cur;
                this.isEnd = isEnd;
            }
            public Node() {
            }

            char cur;
            boolean isEnd;
            Map<Character, Node> children = new HashMap<>();
        }

        public Trie() {
            head = new Node();
        }

        public void insert(String word) {
            char[] ws = word.toCharArray();
            Node cur = head;
            for (int i = 0; i < ws.length; i++) {
                char c = ws[i];
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node(c, i == ws.length - 1));
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            char[] ws = word.toCharArray();
            Node cur = head;
            for (char c : ws) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] ws = prefix.toCharArray();
            Node cur = head;
            for (char c : ws) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            return true;
        }
    }
}
