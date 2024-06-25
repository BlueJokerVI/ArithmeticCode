package _016_bitwise;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    class Solution {
        public int hammingWeight(int n) {
            int cnt = 0;
            for (int i = 0; i < 32; i++) {
                cnt += n & 1;
                n >>>= 1;
            }
            return cnt;
        }
    }

    public class Solution1 {
        public int hammingWeight(int n) {
            int res = 0;
            // n = n&(n-1)每次消去n中的一个1
            /**
             * n     = 1 0 1 0 1 0 0 0
             * n-1   = 1 0 1 0 0 1 1 1
             * n&n-1 = 1 0 1 0 0 0 0 0
             */
            while (n != 0) {
                res++;
                n &= n - 1;
            }
            return res;
        }
    }

}
