package _017_math;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/palindrome-number/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int pre = x;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return pre == reverse;
    }
}
