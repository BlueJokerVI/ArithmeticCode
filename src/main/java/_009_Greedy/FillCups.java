package _009_Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 */
public class FillCups {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : amount) {
            if (v != 0) {
                q.offer(v);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            Integer v = q.poll();
            if (!q.isEmpty()) {
                ans++;
                Integer k = q.poll();
                v--;
                k--;
                if (v != 0) {
                    q.offer(v);
                }
                if (k != 0) {
                    q.offer(k);
                }
            } else {
                ans += v;
            }
        }
        return ans;
    }
}
