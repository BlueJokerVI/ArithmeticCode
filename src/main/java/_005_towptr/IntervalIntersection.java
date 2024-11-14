package _005_towptr;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/interval-list-intersections/
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = firstList.length;
        int f = 0;
        int m = secondList.length;
        int s = 0;

        while (f < n && s < m) {
            int fl = firstList[f][0];
            int fr = firstList[f][1];

            int sl = secondList[s][0];
            int sr = secondList[s][1];


            int l = Math.max(fl, sl);
            int r = Math.min(fr, sr);

            if (l <= r) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(l);
                tmp.add(r);
                ans.add(tmp);
            }

            if (sr > fr) {
                f++;
            } else {
                s++;
            }

        }
        return ans.stream().map(v -> v.stream().mapToInt(t -> t).toArray()).toArray(int[][]::new);
    }
}
