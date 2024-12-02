package _008_Backtracking;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cct
 * https://leetcode.cn/problems/furthest-building-you-can-reach/
 */
public class FurthestBuilding {


    //贪心 + 优先队列
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int max = Integer.MIN_VALUE;
        int n = heights.length;
        PriorityQueue<Integer> maxD = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n - 1; i++) {
            if (heights[i + 1] > heights[i]) {
                int dh = heights[i + 1] - heights[i];
                maxD.add(dh);
                if (bricks >= dh) {
                    bricks -= dh;
                } else {
                    while (ladders > 0 && !maxD.isEmpty() && bricks < dh) {
                        bricks += maxD.poll();
                        ladders--;
                    }

                    if (bricks < dh) {
                        return i;
                    }

                    bricks -= dh;
                }
            }
        }

        return n - 1;
    }

}
