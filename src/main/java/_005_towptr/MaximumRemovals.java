package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-number-of-removable-characters/
 */
public class MaximumRemovals {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        //vis标记位置cs[i]是否可以使用
        int[] vis = new int[s.length()];
        Arrays.fill(vis, 100005);
        for (int i = 0; i < removable.length; i++) {
            vis[removable[i]] = i;
        }

        //二分枚举k值
        int l = 0, r = n - 1;
        int k = -1;
        //0 1 2
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (can(cs, cp, vis, mid)) {
                l = mid + 1;
                k = mid;
            } else {
                r = mid - 1;
            }
        }
        return k + 1;
    }

    boolean can(char[] cs, char[] cp, int[] vis, int mid) {

        int l = 0;
        int r = 0;
        int n = cs.length;
        int m = cp.length;
        while (l < n && r < m) {
            while (l < n && (cp[r] != cs[l] || vis[l] <= mid)) {
                l++;
            }
            if (l == n) {
                return false;
            }
            l++;
            r++;
        }
        return r == m;
    }

    public static void main(String[] args) {
        MaximumRemovals t = new MaximumRemovals();
        t.maximumRemovals("qobftgcueho","obue",new int[]{5,3,0,6,4,9,10,7,2,8});
    }
}
