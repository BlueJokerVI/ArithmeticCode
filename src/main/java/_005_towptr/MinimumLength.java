package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/
 */
public class MinimumLength {
    public int minimumLength(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while (l < r && cs[l] == cs[r]) {
            char c = cs[l];
            while (l <= r && cs[l] == c) {
                l++;
            }
            while (l <= r && cs[r] == c) {
                r--;
            }
        }
        return r - l + 1;
    }

    public static void main(String[] args) {
        MinimumLength minimumLength = new MinimumLength();
        minimumLength.minimumLength("aabccabba");
    }
}
