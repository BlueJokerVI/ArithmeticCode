package _009_Greedy;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author cct
 * https://leetcode.cn/problems/p0NxJO/
 */
public class MagicTower {
    public int magicTower(int[] nums) {
        Queue<Integer> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        q.offer(1);
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            q.offer(nums[i]);
        }

        if (sum < 0) {
            return -1;
        }

        long cur = 0;
        int ans = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            if (v < 0) {
                pq.offer(v);
            }

            if (cur + v <= 0) {
                ans++;
                int mv = pq.poll();
                cur = cur - mv + v;
                q.offer(mv);
            } else {
                cur += v;
            }
        }
        return ans;
    }
}
