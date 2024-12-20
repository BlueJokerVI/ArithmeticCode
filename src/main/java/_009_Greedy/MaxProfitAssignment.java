package _009_Greedy;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author cct
 * https://leetcode.cn/problems/most-profit-assigning-work/
 */
public class MaxProfitAssignment {


    //排利润法
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> profit[b] - profit[a]);
        TreeMap<Integer, Integer> wmp = new TreeMap<>();
        for (int w : worker) {
            wmp.merge(w, 1, Integer::sum);
        }

        int ans = 0;
        for (int i : idx) {
            Integer key = wmp.ceilingKey(difficulty[i]);
            while (key != null) {
                ans += profit[i];
                wmp.merge(key, -1, Integer::sum);
                if (wmp.get(key) == 0) {
                    wmp.remove(key);
                }
                key = wmp.ceilingKey(difficulty[i]);
            }
        }

        return ans;
    }

    //排难度和工人能力
    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> difficulty[a] - difficulty[b]);
        Arrays.sort(worker);

        //最大利润
        int mp = 0;
        //难度指针
        int j = 0;

        int ans = 0;
        for (int w : worker) {
            while (j < n && difficulty[idx[j]] <= w) {
                mp = Math.max(mp, profit[idx[j]]);
                j++;
            }
            ans += mp;
        }

        return ans;
    }
}
