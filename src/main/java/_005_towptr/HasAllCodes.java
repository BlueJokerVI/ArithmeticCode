package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */
public class HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        int cnt = 0;
        boolean[] mp = new boolean[2000000];
        int v = 0;
        char[] chars = s.toCharArray();

        if(s.length() <= k){
            return false;
        }

        for (int i = k - 1; i >= 0; i--) {
            v += chars[i] - '0' == 1 ? Math.pow(2, k - 1 - i) : 0;
        }
        cnt++;
        mp[v] = true;
        for (int i = k; i < s.length(); i++) {
            if (chars[i - k] == '1') {
                v -= Math.pow(2, k - 1);
            }
            v *= 2;
            v += chars[i] - '0' == 1 ? 1 : 0;
            if (!mp[v]) {
                mp[v] = true;
                cnt++;
            }
        }
        return cnt == Math.pow(2, k);
    }
}
