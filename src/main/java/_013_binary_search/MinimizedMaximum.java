package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/minimized-maximum-of-products-distributed-to-any-store/
 */
public class MinimizedMaximum {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = 0;
        for (int quantity : quantities) {
            r = Math.max(r, quantity);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if(check(quantities,mid,n)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return r + 1;
    }

    boolean check(int[] quantities, int mid, int n) {
        int t = 0;
        int index = 0;
        int m = quantities.length;
        while (index < m) {
            int v = quantities[index++];
            t += v / mid;
            if (v % mid != 0) {
                t++;
            }

            if (t > n) {
                return false;
            }
        }
        return true;
    }
}
