package _017_math;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sqrtx/?envType=study-plan-v2&envId=top-interview-150
 */
public class MySqrt {

    //暴力解法
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long v = 0;
        for (long i = 1; i <= x / 2; i++) {
            if (i * i <= x) {
                v = i;
            } else {
                return (int) v;
            }
        }
        return (int) v;
    }


    //二分
    public int mySqrt1(int x) {
        int l = 1;
        int r = x;
        // 1 2 3 4
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (long)l*l > x ? l-1 : l;
    }
}
