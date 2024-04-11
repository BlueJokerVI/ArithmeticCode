package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/fibonacci-number/
 */
public class FIb {

    //斐波那契
    public int fib(int n) {
        int[] fn = new int[31];
        fn[0] = fn[1] = 1;
        for(int i=2;i<=n;i++){
            fn[i] = fn[i-1] + fn[i-2];
        }

        return fn[n];
    }
}
