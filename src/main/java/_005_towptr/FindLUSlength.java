package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
public class FindLUSlength {
    public int findLUSlength(String[] strs) {
        int ans = -1;

        //枚举特殊串在str[i]
        for (int i = 0; i < strs.length; i++) {

            boolean find = true;
            for (int j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }

                char[] s = strs[i].toCharArray();
                char[] t = strs[j].toCharArray();
                int n = s.length;
                int m = t.length;
                int l = 0, r = 0;

                while (l < n && r < m) {
                    while (r < m && t[r] != s[l]) {
                        r++;
                    }

                    if (r == m) {
                        break;
                    }
                    l++;
                    r++;
                }

                if (l == n) {
                    find = false;
                    break;
                }
            }

            if (find) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        FindLUSlength findLUSlength = new FindLUSlength();
        findLUSlength.findLUSlength(new String[]{"aba", "cdc", "eae"});
    }
}
