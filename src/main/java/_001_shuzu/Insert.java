package _001_shuzu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }

        List<int[]> ans = new LinkedList<>();

        //记录newInterval位置
        int index = -1;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0] > newInterval[0]){
                index = i;
                break;
            }
        }

        if(index==0){
            int l = newInterval[0];
            int r = newInterval[1];
            for(int i=0;i<intervals.length;i++){
                if(r>=intervals[i][0]){
                    r = Math.max(r,intervals[i][1]);
                }else {
                    ans.add(new int[]{l,r});
                    l = intervals[i][0];
                    r = intervals[i][1];
                }

                if(i==intervals.length-1){
                    ans.add(new int[]{l,r});
                }
            }
        }else {
            int l = intervals[0][0];
            int r = intervals[0][1];

            if(intervals.length==1){
                if(r>=newInterval[0]){
                    r = Math.max(r,newInterval[1]);
                    ans.add(new int[]{l,r});
                }else {
                    ans.add(new int[]{l,r});
                    ans.add(new int[]{newInterval[0],newInterval[1]});
                }
                return ans.toArray(new int[ans.size()][]);
            }

            for(int i=1;i<intervals.length;i++){
                if(i==index){
                    if(r>=newInterval[0]){
                        r = Math.max(r,newInterval[1]);
                    }else {
                        ans.add(new int[]{l,r});
                        l = newInterval[0];
                        r = newInterval[1];
                    }
                }

                if(r>=intervals[i][0]){
                    r = Math.max(r,intervals[i][1]);
                }else {
                    ans.add(new int[]{l,r});
                    l = intervals[i][0];
                    r = intervals[i][1];
                }

                if(i==intervals.length-1 ){
                    if(index!=-1){
                        ans.add(new int[]{l,r});
                    }else {
                        if(r>=newInterval[0]){
                            r = Math.max(r,newInterval[1]);
                            ans.add(new int[]{l,r});
                        }else {
                            ans.add(new int[]{l,r});
                            ans.add(new int[]{newInterval[0],newInterval[1]});
                        }
                    }

                }
            }

        }
        return ans.toArray(new int[ans.size()][]);
    }


    //简介写法  6666666
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int start = newInterval[0], end = newInterval[1];
            for (int[] interval : intervals) {
                if (start > interval[1]) {
                    res.add(interval);
                } else if (end < interval[0]) {
                    res.add(new int[]{start, end});
                    start = interval[0];
                    end = interval[1];
                } else {
                    start = Math.min(start, interval[0]);
                    end = Math.max(end, interval[1]);
                }
            }
            res.add(new int[]{start, end});

            int[][] ans = new int[res.size()][0];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }

            return ans;
        }
    }


    @Test
    public void test(){
        insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
    }
}
