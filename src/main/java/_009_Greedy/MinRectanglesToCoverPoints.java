package _009_Greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-rectangles-to-cover-points/
 */
public class MinRectanglesToCoverPoints {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Set<Integer> xSet = new HashSet<>();
        for (int[] point : points) {
            xSet.add(point[0]);
        }
        int[] x = xSet.stream().mapToInt(Integer::intValue).sorted().toArray();
        int ans = 0;
        int n = x.length;
        int l = 0;
        while (l < n) {
            ans++;
            int next = x[l] + w;
            while (l < n && x[l] <= next) {
                l++;
            }
        }
        return ans;
    }
}
