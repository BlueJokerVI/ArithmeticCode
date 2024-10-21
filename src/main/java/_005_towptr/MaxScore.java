package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int cur = 0;
        int max = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            cur += cardPoints[i];
        }
        max = cur;

        int l = n - 1, r = k - 1;
        for (; r >= 0; r--) {
            cur -= cardPoints[r];
            cur += cardPoints[l--];
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
