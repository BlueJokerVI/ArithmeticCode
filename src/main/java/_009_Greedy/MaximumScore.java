package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/uOAnQW/
 */
public class MaximumScore {
    public int maximumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int ans = 0;
        //n-1 -x +1 = cnt    x = n-cnt
        for (int i = n - 1; i >= n - cnt; i--) {
            ans += cards[i];
        }
        if (ans % 2 == 0) {
            return ans;
        }
        int tmp1 = 0;
        int i = n - cnt - 1;
        while (i >= 0 && cards[i] % 2 == cards[n - cnt] % 2) {
            i--;
        }
        if (i >= 0) {
            tmp1 = ans - cards[n - cnt] + cards[i];
        }

        i = n - cnt + 1;
        while (i < n && cards[i] % 2 == cards[n - cnt] % 2) {
            i++;
        }
        int tmp2 = 0;
        if (i < n) {
            int j = n - cnt - 1;
            while (j >= 0 && cards[j] % 2 == cards[i] % 2) {
                j--;
            }
            if (j >= 0) {
                tmp2 = ans - cards[i] + cards[j];
            }
        }

        return Math.max(tmp1, tmp2);
    }

    public static void main(String[] args) {
        MaximumScore t = new MaximumScore();
        t.maximumScore(new int[]{1, 2, 8, 9}, 3);
    }
}
