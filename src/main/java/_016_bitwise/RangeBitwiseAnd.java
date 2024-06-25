package _016_bitwise;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/bitwise-and-of-numbers-range/?envType=study-plan-v2&envId=top-interview-150
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int l, int r) {
        int result = l;
        // 如果l == r，直接返回l或r
        if (l == r) {
            return l;
        }

        // 因为0 & x = 0，且r&(r-1)后，r的最后一位1的位置（包括该1位）后全为0，故可以跳过许多不必要的判断
        // 通过检查每一位的变化来确定按位与的结果是否为0
        while (l < r) {
            /**
             * r        1 0 1 0 1 1 0
             * r-1      1 0 1 0 1 0 1
             * r&(r-1)  1 0 1 0 1 0 0
             */
            r &= (r - 1); // 清除r最右边的1
        }
        return r;
    }



    //公共前缀，也是用了n&(n-1)的性质
    public int rangeBitwiseAnd1(int l, int r) {
        int shift = 0;
        while (l<r){
            l>>=1;
            r>>=1;
            shift++;
        }
        return l<<shift;
    }

}
