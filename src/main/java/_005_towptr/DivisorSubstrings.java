package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-the-k-beauty-of-a-number/
 */
public class DivisorSubstrings {
    public int divisorSubstrings(int num, int k) {
        StringBuilder ns = new StringBuilder();
        int t = num;
        while (t != 0) {
            int v = t % 10;
            t /= 10;
            ns.append(v);
        }
        int n = ns.length();
        char[] s = ns.toString().toCharArray();
        int ans = 0;
        int cur = 0, pk = 1;
        //n-1 -x +1 = k  x = n-k
        for (int i = n - 1; i >= n - k; i--) {
            cur = cur * 10 + s[i] - '0';
            pk *= 10;
        }

        if (cur != 0 && num % cur == 0) {
            ans++;
        }
        for (int i = n - k - 1; i >= 0; i--) {
            cur = cur * 10 + s[i] - '0' - (s[i + k] - '0') * pk * 10;

            if (cur != 0 && num % cur == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        DivisorSubstrings divisorSubstrings = new DivisorSubstrings();
        divisorSubstrings.divisorSubstrings(240,2);
    }
}
