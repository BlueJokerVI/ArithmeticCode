package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int weight : weights) {
            r += weight;
            l = Math.max(l, weight);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if(check(weights,mid,days)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return r + 1;
    }


    boolean check(int[] w, int mw, int days) {
        int s = 1;
        int v = 0;
        for (int i : w) {
            v += i;
            if (v > mw) {
                s++;
                v = i;
            }
            if (s > days) {
                return false;
            }
        }
        return true;
    }
}
