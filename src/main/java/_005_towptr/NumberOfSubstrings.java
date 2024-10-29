package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/
 */
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        int[] cnt = new int[4];
        int t = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt[cs[i] & 31]++;
            if (cnt[cs[i] & 31] == 1) {
                t++;
            }

            while (t == 3) {
                ans += n - i;
                cnt[cs[l] & 31]--;
                if (cnt[cs[l] & 31] == 0) {
                    t--;
                }
                l++;
            }
        }
        return ans;
    }


    /**
     * <a href="https://leetcode.cn/problems/count-substrings-with-k-frequency-characters-i/">...</a>
     *
     * @param s
     * @param k
     * @return
     */
    public int numberOfSubstrings(String s, int k) {
        int[] cnt = new int[27];
        char[] cs = s.toCharArray();
        int n = cs.length;
        int l = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cnt[cs[i] & 31]++;
            while (cnt[cs[i] & 31] == k) {
                ans += n - i;
                cnt[cs[l] & 31]--;
                l++;
            }
        }
        return ans;
    }

}
