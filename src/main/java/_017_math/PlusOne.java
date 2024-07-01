package _017_math;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/plus-one/?envType=study-plan-v2&envId=top-interview-150
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int m = 1;
        int index = digits.length - 1;
        while (m != 0 && index >= 0) {
            int v = digits[index] + m;
            digits[index] = v % 10;
            m = v / 10;
            index--;
        }

        if (m != 0) {
            //最高位位1，其它位都为0
            int[] ans =  new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }else {
            return digits;
        }
    }
}
