package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/u/bai-ai-ai/
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int[] piles, int mid, int h) {
        int s = 0;
        for (int i = 0; i < piles.length; i++) {

            //避免使用double计算
            s += (piles[i] + mid - 1) / mid;
            if (s > h) {
                return false;
            }
        }
        return true;
    }
}
