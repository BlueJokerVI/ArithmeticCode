package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/longest-happy-string/
 */
public class LongestDiverseString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder str = new StringBuilder();
        while (a > 0 || b > 0 || c > 0) {

            if (a >= b && a >= c) {
                if (str.length() < 2 || !str.substring(str.length() - 2).equals("aa")) {
                    str.append("a");
                    a--;
                    continue;
                }

                if (b > c) {
                    if (b > 0) {
                        str.append("b");
                        b--;
                        continue;
                    }
                } else {
                    if (c > 0) {
                        c--;
                        str.append("c");
                        continue;
                    }
                }
            } else if (b >= c && b >= a) {
                if (str.length() < 2 || !str.substring(str.length() - 2).equals("bb")) {
                    str.append("b");
                    b--;
                    continue;
                }

                if (a > c) {
                    if (a > 0) {
                        str.append("a");
                        a--;
                        continue;
                    }
                } else {
                    if (c > 0) {
                        c--;
                        str.append("c");
                        continue;
                    }
                }

            } else {
                if (str.length() < 2 || !str.substring(str.length() - 2).equals("cc")) {
                    str.append("c");
                    c--;
                    continue;
                }

                if (b > a) {
                    if (b > 0) {
                        b--;
                        str.append("b");
                        continue;
                    }
                } else {
                    if (a > 0) {
                        a--;
                        str.append("a");
                        continue;
                    }
                }
            }

            return str.toString();
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LongestDiverseString t = new LongestDiverseString();
        t.longestDiverseString(1,1,7);
    }
}
