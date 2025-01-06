package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/string-without-aaa-or-bbb/
 */
public class StrWithout3a3b {
    public String strWithout3a3b(int a, int b) {
        StringBuilder str = new StringBuilder();
        while (a > 0 || b > 0) {
            if (a > b) {
                if (str.length() < 2 || !str.substring(str.length() - 2).equals("aa")) {
                    str.append("a");
                    a--;
                } else {
                    b--;
                    str.append("b");
                }
            } else {
                if (str.length() < 2 || !str.substring(str.length() - 2).equals("bb")) {
                    str.append("b");
                    b--;
                } else {
                    str.append("a");
                    a--;
                }
            }
        }
        return str.toString();
    }
}
