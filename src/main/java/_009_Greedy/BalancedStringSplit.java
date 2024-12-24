package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/split-a-string-in-balanced-strings/
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        int l = 0, r = 0;
        for (char c : cs) {
            if (c == 'L') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                ans++;
                l = 0;
                r = 0;
            }
        }
        return ans;
    }
}
