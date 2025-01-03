package _009_Greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author cct
 * https://leetcode.cn/problems/distant-barcodes/
 */
public class RearrangeBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int v : barcodes) {
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }

        mp.forEach((k, v) -> {
            q.offer(new int[]{k, v});
        });

        int n = barcodes.length;
        int[] ans = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int[] v1 = q.poll();
            int[] v2 = q.poll();
            ans[index++] = v1[0];
            if (v2 == null) {
                break;
            }
            ans[index++] = v2[0];
            v1[1]--;
            v2[1]--;
            if (v1[1] != 0)
                q.offer(v1);
            if (v2[1] != 0)
                q.offer(v2);
        }
        return ans;
    }

    public static void main(String[] args) {
        RearrangeBarcodes t = new RearrangeBarcodes();
        t.rearrangeBarcodes(new int[]{7, 7, 7, 8, 5, 7, 5, 5, 5, 8});
    }
}
