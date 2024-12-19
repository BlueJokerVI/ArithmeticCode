package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/check-if-a-string-can-break-another-string/
 */
public class CheckIfCanBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return can(a, b) || can(b, a);

    }

    boolean can(char[] a, char[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (b[i] < a[i]) {
                return false;
            }
        }
        return true;
    }
}
