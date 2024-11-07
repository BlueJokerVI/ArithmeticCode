package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/bag-of-tokens/
 */
public class BagOfTokensScore {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int score = 0;

        //左边买分 、 右边买能量
        while (l <= r) {
            if (power >= tokens[l]) {
                score++;
                power -= tokens[l];
                l++;
            } else if (score > 0 && r != l && power + tokens[r] >= tokens[l]) {
                power = power + tokens[r];
                r--;
                score--;
            } else {
                return score;
            }
        }
        return score;
    }
}
