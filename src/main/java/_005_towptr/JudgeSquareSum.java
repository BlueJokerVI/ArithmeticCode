package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {


    //a^2 + b^2 = c
    //[0,1,4,9,16.....]
    public boolean judgeSquareSum(int c) {
        long a = 0, b = (long) Math.sqrt(c);


        while (a <= b) {
            long v = a * a + b * b;
            if (v == c) {
                return true;
            }

            if (v > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

}
