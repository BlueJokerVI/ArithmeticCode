package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
 */
public class MinFlips {
    public int minFlips(String s) {
        int len = s.length();
        char[] ss = (s + s).toCharArray();
        char[] target = {'1', '0'};
        int cnt = 0;
        //先统计只通过操作二翻转，得到目标串所需的最少操作次数
        for (int i = 0; i < len; i++) {
            if (ss[i] != target[i % 2]) {
                cnt++;
            }
        }
        //10 转目标串需要cnt次操作  01串转10串需要len次操作   01串转目标串需要len - cnt次操作
        int ans = Math.min(cnt, len - cnt);

        //统计通过操作一与操作二一起操作需要的次数
        for (int l = 0; l < len; l++) {
            if (ss[l] != target[l % 2]) {
                cnt--;
            }
            //相当于操作一，将头元素移到尾部
            if (ss[l + len] != target[(l + len) % 2]) {
                cnt++;
            }
            ans = Math.min(ans, Math.min(cnt, len - cnt));
        }
        return ans;
    }
}
