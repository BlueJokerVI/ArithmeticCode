package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] mp = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            if (tops[i] == bottoms[i]) {
                mp[tops[i]]++;
            } else {
                mp[tops[i]]++;
                mp[bottoms[i]]++;
            }
        }

        int mCnt = 0;
        int mVal = 0;
        for (int i = 1; i <= 6; i++) {
            if (mp[i] > mCnt) {
                mCnt = mp[i];
                mVal = i;
            }
        }

        if (mCnt < n) {
            return -1;
        }

        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != mVal) {
                ans1++;
            }

            if (bottoms[i] != mVal) {
                ans2++;
            }
        }

        return Math.min(ans1, ans2);
    }
}
