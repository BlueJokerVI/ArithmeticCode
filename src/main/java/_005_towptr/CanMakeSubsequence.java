package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/make-string-a-subsequence-using-cyclic-increments/
 */
public class CanMakeSubsequence {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] s2 = str2.toCharArray();
        char[] s1 = str1.toCharArray();

        int n = s2.length;
        int m = s1.length;
        int t = 0, cur = 0;

        while (t < n && cur < m) {
            while (cur < m && !find(s1[cur],s2[t])) {
                cur++;
            }

            if (cur == m) {
                return false;
            }

            cur++;
            t++;
        }

        return t == n;
    }

    private boolean find(char a, char b) {
        if (a == b || a + 1 == b) {
            return true;
        }

        return a == 'z' && b == 'a';
    }


    public static void main(String[] args) {
        CanMakeSubsequence t = new CanMakeSubsequence();
        t.canMakeSubsequence("abc", "ad");
    }
}
