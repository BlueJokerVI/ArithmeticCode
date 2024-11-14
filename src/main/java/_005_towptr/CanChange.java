package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
 */
public class CanChange {
    public boolean canChange(String start, String target) {
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int n = t.length;
        int l = 0, r = n - 1;
        int ls = 0, rs = r;
        while (l < n && ls < n ) {
            int cntR = 0;
            while (l < n && t[l] != 'L') {
                if (t[l] == 'R') {
                    cntR++;
                }
                l++;
            }
            while (ls < n && s[ls] != 'L') {
                if (s[ls] == 'R') {
                    cntR--;
                }
                ls++;
            }
            if (cntR != 0 || ls < l) {
                return false;
            }
            if((ls!=n && l==n) || (ls==n && l!=n)){
                return false;
            }

            l++;
            ls++;
        }

        while (r>=0 && rs>=0){
            int cntL = 0;

            while (0 <= r && t[r] != 'R') {
                if (t[r] == 'L') {
                    cntL++;
                }
                r--;
            }

            while (0 <= rs && s[rs] != 'R') {
                if (s[rs] == 'L') {
                    cntL--;
                }
                rs--;
            }
            if (cntL != 0 || rs > r ) {
                return false;
            }
            if((rs!=0 && r==0) || (rs==0 && rs!=0)){
                return false;
            }
            r--;
            rs--;
        }

        return true;
    }


    public static void main(String[] args) {
        CanChange t = new CanChange();
        t.canChange("_R","R_");
    }
}
