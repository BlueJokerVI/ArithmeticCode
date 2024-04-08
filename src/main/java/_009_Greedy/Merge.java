package _009_Greedy;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/merge-intervals/
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o->o[0]));

        List<List<Integer>> ans = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];

        for (int i=1;i<intervals.length;i++){
            if(r>=intervals[i][0]){
                r = Math.max(r,intervals[i][1]);
            }else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(l);
                integers.add(r);
                ans.add(integers);
                l = intervals[i][0];
                r = intervals[i][1];
            }

            if(i==intervals.length-1){
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(l);
                integers.add(r);
                ans.add(integers);
            }
        }

        return ans.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }


    //
    public int[][] merge1(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按照左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        //initial start 是最小左边界
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (intervals[i][0] > rightmostRightBound) {
                //加入区间 并且更新start
                res.add(new int[]{start, rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            } else {
                //更新最大右边界
                rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }

}
