package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/remove-adjacent-almost-equal-characters/
 */
public class RemoveAlmostEqualCharacters {
    public int removeAlmostEqualCharacters(String word) {

        // abddez
        int ans = 0;
        char[] cs = word.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && Math.abs(cs[i] - cs[i + 1]) <= 1) {
                ans++;
                if (i + 2 < n && Math.abs(cs[i + 1] - cs[i + 2]) <= 1) {
                    i++;
                }
            }
        }
        return ans;
    }
}
