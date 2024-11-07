package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
 */
public class CheckPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        //判断a,b自身是否是回文串
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int n = ca.length;

        if (huiwen(ca, 0, n - 1) || huiwen(cb, 0, n - 1)) {
            return true;
        }

        int l = 0, r = n - 1;
        while (l < r && ca[l] == cb[r]) {
            l++;
            r--;
        }

        if (l >= r || huiwen(cb,l,r) || huiwen(ca,l,r) ) {
            return true;
        }

        l = 0;
        r = n - 1;
        while (l < r && ca[r] == cb[l]) {
            l++;
            r--;
        }

        return l >= r || huiwen(cb,l,r) || huiwen(ca,l,r);
    }

    private boolean huiwen(char[] a, int l, int r) {
        while (l < r && a[l] == a[r]) {
            l++;
            r--;
        }
        return l >= r;
    }

    public static void main(String[] args) {
        CheckPalindromeFormation x = new CheckPalindromeFormation();
        x.checkPalindromeFormation("pvhmupgqeltozftlmfjjde","yjgpzbezspnnpszebzmhvp");
    }
}
