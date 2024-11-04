package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/
 */
public class MaxRepOpt1 {
    public int maxRepOpt1(String text) {
        int ans = 0;
        char[] cs = text.toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];
        for (char c1 : cs) {
            cnt[c1 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            char c = (char) ('a' + i);
            int dif = 0;
            int tmp = 0;
            boolean used = false;
            for (int l = 0, r = 0; r < n; r++) {
                if (c != cs[r]) {
                    dif++;
                }
                while (dif > 1) {
                    if (cs[l] != c) {
                        dif--;
                    }
                    l++;
                }

                if (r - l + 1 > tmp) {
                    tmp = r - l + 1;
                    if (dif == 1) {
                        used = true;
                    }
                }
            }
            if (cnt[i] > tmp && !used) {
                tmp++;
            }

            if (cnt[i] < tmp) {
                tmp--;
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }


    public int maxRepOpt11(String text) {
        int ans = 0;
        char[] cs = text.toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];
        for (char c1 : cs) {
            cnt[c1 - 'a']++;
        }

        for (int l = 0, r = 0; r < n; r++) {

            while (r < n && cs[l] == cs[r]) {
                r++;
            }

            int k = r + 1;
            while (k < n && cs[l] == cs[k]) {
                k++;
            }
            ans = Math.max(ans, Math.min(k - l, cnt[cs[l] - 'a']));
            l = r;
        }
        return ans;
    }


    public static void main(String[] args) {
        MaxRepOpt1 maxRepOpt1 = new MaxRepOpt1();
        maxRepOpt1.maxRepOpt1("ababa");
    }
}
