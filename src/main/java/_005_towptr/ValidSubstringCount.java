package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/
 */
public class ValidSubstringCount {
    public long validSubstringCount(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[] cnt2 = new int[27];
        int[] cnt1 = new int[27];
        int dif = 0;
        for (char c : cs2) {
            cnt2[c & 31]++;
            if (cnt2[c & 31] == 1) {
                dif++;
            }
        }

        long ans = 0;
        int t = 0;
        int l = 0;
        int n = cs1.length;
        for (int i = 0; i < n; i++) {
            cnt1[cs1[i] & 31]++;
            if (cnt1[cs1[i] & 31] == cnt2[cs1[i] & 31]) {
                t++;
            }

            while (t == dif) {
                ans += n - i;
                cnt1[cs1[l] & 31]--;
                if (cnt1[cs1[l] & 31] == cnt2[cs1[l] & 31] - 1) {
                    t--;
                }
                l++;
            }
        }
        return ans;
    }
}
