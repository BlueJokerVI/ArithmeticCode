package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-swaps-to-arrange-a-binary-grid/
 */
public class MinSwaps {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] ss = new int[n];

        for (int i = 0; i < n; i++) {
            int[] g = grid[i];
            int idx = n - 1;
            while (idx >= 1 && g[idx] == 0) {
                idx--;
            }
            ss[i] = n - idx - 1;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (ss[i] < n - 1 - i) {
                int idx = i + 1;
                while (idx < n && ss[idx] < n - 1 - i) {
                    idx++;
                }

                if (idx < n) {
                    ans += idx - i;
                    int tmp = ss[idx];
                    while (idx > i) {
                        ss[idx] = ss[idx - 1];
                        idx--;
                    }
                    ss[i] = tmp;
                } else {
                    return -1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinSwaps t = new MinSwaps();
        t.minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}});
    }
}
