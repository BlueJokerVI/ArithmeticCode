package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-repeating-character-replacement/
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while (r < n && cs[l] == cs[r]) {
                r++;
            }

            int t = r;
            int tk = k;
            while (t < n && (cs[l] == cs[t] || tk > 0)) {
                if (cs[l] != cs[t]) {
                    tk--;
                }
                t++;
            }

            int tl = l - Math.min(tk, l);

            ans = Math.max(ans, t - tl);
            l = r;
        }
        return ans;
    }

    public int characterReplacement1(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int left = 0, right = 0, i = 0, maxCount = 0;
        while (right < arr.length) {
            i = arr[right]-'A';
            freq[i]++;
            maxCount = Math.max(maxCount, freq[i]);
            while (right - left + 1 > maxCount + k) {
                freq[arr[left]-'A']--;
                left++;
            }
            right++;
        }
        return Math.min(maxCount + k, arr.length);
    }

}
