package _009_Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author cct
 * https://leetcode.cn/problems/divide-intervals-into-minimum-number-of-groups/
 */
public class MinGroups {

    //红黑树模拟
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        mp.put(intervals[0][1], 1);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            Integer key = mp.lowerKey(intervals[i][0]);
            if (key == null) {
                mp.put(intervals[i][1], mp.getOrDefault(intervals[i][1], 0) + 1);
            } else {
                if (mp.get(key) - 1 == 0) {
                    mp.remove(key);
                } else {
                    mp.put(key, mp.get(key) - 1);
                }
                mp.put(intervals[i][1], mp.getOrDefault(intervals[i][1], 0) + 1);
            }
        }
        int ans[] = new int[1];
        mp.forEach((k, v) -> {
            ans[0] += v;
        });

        return ans[0];
    }

    //堆 + 贪心
    public int minGroups1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] p : intervals) {
            if (!pq.isEmpty() && pq.peek() < p[0]) pq.poll();
            pq.offer(p[1]);
        }
        return pq.size();
    }
}
