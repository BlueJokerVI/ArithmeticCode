package _009_Greedy;

import _000000_crawer.Main;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/non-overlapping-intervals/
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int cnt = 0;
        int pre = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(pre<=intervals[i][0]){
                pre = intervals[i][1];
            }else {
                cnt++;
                pre = Math.min(pre,intervals[i][1]);
            }
        }
        return cnt;
    }
}
