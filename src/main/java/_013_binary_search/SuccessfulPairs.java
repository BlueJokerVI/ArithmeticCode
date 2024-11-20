package _013_binary_search;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long v = (long) Math.ceil((double) success / spells[i]);

            int pn = potions.length;
            int l = 0, r = pn - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (potions[mid] < v) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l < pn) {
                ans[i] = pn  - l ;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}
