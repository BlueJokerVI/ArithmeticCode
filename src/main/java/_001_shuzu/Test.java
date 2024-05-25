package _001_shuzu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Test {
    public int[][] merge(int[][] intervals) {


        if(intervals.length==1){
            return intervals;
        }

        List<int[]> collect = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0])).collect(Collectors.toList());
       List<List<Integer>> ans = new ArrayList<>();

       int l = collect.get(0)[0];
       int r = collect.get(0)[1];

        for (int i = 1; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            if(r >= ints[0]){
                r = Math.max(r,ints[1]);
            }else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(l);
                tmp.add(r);
                ans.add(tmp);
                l = ints[0];
                r = ints[1];
            }

            if(i==collect.size()-1){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(l);
                tmp.add(r);
                ans.add(tmp);
            }
        }

        return ans.stream().map((list)-> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
