package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/
 */
public class CountKConstraintSubstrings {
    public int countKConstraintSubstrings(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        int[] cnt = new int[2];
        for (int l = 0, r = 0; r < n; r++) {
            cnt[cs[r] - '0']++;
            while (l <= r && cnt[0] > k && cnt[1] > k) {
                cnt[cs[l] - '0']--;
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
