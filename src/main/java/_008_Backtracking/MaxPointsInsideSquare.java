package _008_Backtracking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-points-inside-the-square/
 */
public class MaxPointsInsideSquare {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        int[][] sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, Comparator.comparingInt(o -> o[0]));

        Set<Character> set = new HashSet<>();

        int ans = 0;
        int i = 0;
        while (i < n) {
            int len = sorted[i][0];
            while (i < n && sorted[i][0] <= len) {
                char c = s.charAt(sorted[i][1]);
                if (set.contains(c)) {
                    return ans;
                }
                set.add(c);
                i++;
            }
            ans = set.size();
        }

        return ans;
    }

    public int maxPointsInsideSquare1(int[][] points, String s) {
        int[] minD = new int[26];
        //存字母最小距离
        Arrays.fill(minD, Integer.MAX_VALUE);
        //维护最小的次小距离
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int d = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            int c = s.charAt(i) - 'a';
            if (d < minD[c]) {
                // d 是目前最小的，那么 minD[c] 是次小的
                min2 = Math.min(min2, minD[c]);
                minD[c] = d;
            } else {
                // d 可能是次小的
                min2 = Math.min(min2, d);
            }
        }
        int ans = 0;
        for (int d : minD) {
            if (d < min2) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        MaxPointsInsideSquare t = new MaxPointsInsideSquare();
        t.maxPointsInsideSquare(new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}}, "abdca");
    }
}
