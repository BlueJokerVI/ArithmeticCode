package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-moves-to-convert-string/
 */
public class MinimumMoves {
    public int minimumMoves(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'X') {
                ans++;
                if (i + 1 < n && cs[i+1]=='X') {
                    cs[i+1] = '0';
                }
                if (i + 2 < n && cs[i+2]=='X') {
                    cs[i+2] = '0';
                }
            }
        }
        return ans;
    }
}
