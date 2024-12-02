package _008_Backtracking;

import java.util.Collections;
import java.util.List;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-number-of-alloys/
 */
public class MaxNumberOfAlloys {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int l = 0, r = Collections.min(stock) + budget;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(composition, stock, cost, mid, n, budget)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
    boolean check(List<List<Integer>> composition, List<Integer> stock, List<Integer> cost, int mid, int n, int budget) {

        for (List<Integer> machine : composition) {
            long money = 0;
            boolean can = true;
            for (int i = 0; i < n; i++) {
                if ((long)mid * machine.get(i) > stock.get(i)) {
                    money += cost.get(i) * ((long) mid * machine.get(i) - stock.get(i));
                    if (money > budget) {
                        can = false;
                        break;
                    }
                }
            }
            if (can) {
                return true;
            }
        }
        return false;
    }
}
