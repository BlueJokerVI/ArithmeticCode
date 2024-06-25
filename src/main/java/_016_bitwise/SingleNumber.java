package _016_bitwise;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-interview-150
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

    @Test
    public void test(){

    }

}
