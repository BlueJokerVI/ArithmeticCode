package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/long-pressed-name/description/
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String Name, String Typed) {
        char[] name = Name.toCharArray();
        int n = name.length;
        char[] typed = Typed.toCharArray();
        int m = typed.length;

        int l = 0, r = 0;
        while (l < n && r < m) {
            int cnt = 1;
            while (l + 1 < n && name[l] == name[l + 1]) {
                cnt++;
                l++;
            }

            int c = 0;
            while (r < m && typed[r] == name[l]) {
                r++;
                c++;
            }

            if (c < cnt) {
                return false;
            }
            l++;
        }


        return l == n && m == r;
    }
}
