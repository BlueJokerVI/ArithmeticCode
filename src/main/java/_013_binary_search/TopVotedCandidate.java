package _013_binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/online-election/
 */
public class TopVotedCandidate {

    List<int[]> top;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        top = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mp.put(persons[i], mp.getOrDefault(persons[i], 0) + 1);
            int v = mp.get(persons[i]);
            if(v >= curMax){
                curMax = v;
                top.add(new int[]{times[i],persons[i]});
            }
        }
    }



    // 1 2 3
    public int q(int t) {
        int l = 0, r= top.size() - 1;
        while (l<=r){
            int mid = (r-l)/2 + l;
            if(top.get(mid)[0] > t){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return top.get(r)[1];
    }

}
