package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/task-scheduler/
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] pre = new int[26];
        Arrays.fill(pre, -200);
        int[][] cnt = new int[26][2];
        int sum = tasks.length;
        for (char c : tasks) {
            cnt[c - 'A'][1]++;
            cnt[c - 'A'][0] = c - 'A';
        }

        Arrays.sort(cnt, (a, b) -> b[1] - a[1]);
        int t = 1;
        while (true) {
            int max = Integer.MIN_VALUE;
            boolean find = false;
            for (int i = 0; i < 26; i++) {
                if (cnt[i][1] == 0) {
                    continue;
                }
                int m = t - pre[cnt[i][0]];
                if (m > n) {
                    find = true;
                    sum--;
                    if (sum == 0) {
                        return t;
                    }
                    pre[cnt[i][0]] = t;
                    cnt[i][1]--;
                    Arrays.sort(cnt, (a, b) -> b[1] - a[1]);
                    break;
                }
                max = Math.max(max, m);
            }
            t += find ? 1 : n - max + 1;
        }
    }


    public int leastInterval1(char[] tasks, int n) {
        int[] cnt = new int[26];
        int max = Integer.MIN_VALUE;
        for (char c : tasks) {
            cnt[c - 'A']++;
            max = Math.max(max, cnt[c - 'A']);
        }
        int sMaxCnt = 0;
        for (int v : cnt) {
            if (v == max) {
                sMaxCnt++;
            }
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + sMaxCnt);
    }


    public static void main(String[] args) {
        LeastInterval t = new LeastInterval();
        t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
