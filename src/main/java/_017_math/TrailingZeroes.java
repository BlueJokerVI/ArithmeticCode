package _017_math;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/factorial-trailing-zeroes/?envType=study-plan-v2&envId=top-interview-150
 */
public class TrailingZeroes {

    //2*5=10，分析阶乘，2的数量远远大于5，所以计算5的个数就可以得出有多少个10，级阶乘结果有多少个0
    //相当于计算5的个数
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    @Test
    public void test() {
        trailingZeroes(16);
    }

}
