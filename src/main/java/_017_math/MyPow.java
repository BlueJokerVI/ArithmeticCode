package _017_math;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/powx-n/?envType=study-plan-v2&envId=top-interview-150
 */
public class MyPow {
    public double myPow(double x, int n) {
        return myPowLong(x,n);
    }


    public double myPowLong(double x, long n) {

        if(n==0 || x==1){
            return 1;
        }

        if(n < 0){
            return myPowLong(1/x,-n);
        }

        if(n==1){
            return x;
        }

        // x ^ n =  x^n/2 * x^n/2
        if(n%2==0){
            double v = myPowLong(x,n/2);
            return v*v;
        }else {
            double v = myPowLong(x,(n-1)/2);
            return x*v*v;
        }
    }
}
