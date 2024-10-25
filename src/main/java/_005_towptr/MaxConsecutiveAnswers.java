package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/
 */
public class MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] cs = answerKey.toCharArray();
        int n = cs.length;

        int mt = 0, f = 0, lt = 0;
        int mf = 0, t = 0, lf = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {
            if (cs[r] == 'F') {
                f++;
            } else {
                t++;
            }

            while (f == k + 1) {
                if (cs[lt] == 'F') {
                    f--;
                }
                lt++;
            }

            while (t == k + 1) {
                if (cs[lf] == 'T') {
                    t--;
                }
                lf++;
            }

            ans = Math.max(ans, Math.max(r - lf + 1, r - lt + 1));

        }
        return ans;
    }
}
