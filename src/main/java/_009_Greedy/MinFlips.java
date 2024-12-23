package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-suffix-flips/
 */
public class MinFlips {
    public int minFlips(String target) {
        boolean c = false;
        char[] cs = target.toCharArray();
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((cs[i] == '0' && c) || (cs[i] == '1' && !c)) {
                ans++;
                c = !c;
            }
        }
        return ans;
    }
}
