package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */
public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int n = chars.length;
        int l = 0;
        int cnt = 0;
        int minW = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            if (chars[r] == 'W') {
                cnt++;
            }

            if (r - l + 1 == k + 1) {
                if (chars[l] == 'W') {
                    cnt--;
                }
                l++;
            }

            if (r - l + 1 == k) {
                if (cnt < minW) {
                    minW = cnt;
                }
            }

        }

        return minW;
    }
}
