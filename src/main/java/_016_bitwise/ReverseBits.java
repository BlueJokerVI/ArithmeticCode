package _016_bitwise;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/reverse-bits/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseBits {
    public int reverseBits(int n) {
        StringBuilder s = new StringBuilder(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println(s);
        StringBuilder reverse = s.reverse();
        System.out.println(reverse);
        return parseSignedBinaryString(reverse.toString());
    }

    public static int parseSignedBinaryString(String binaryString) {
        // 如果二进制字符串的长度为32，并且以'1'开头，表示这是一个负数
        if (binaryString.length() == 32 && binaryString.charAt(0) == '1') {
            // 将字符串解释为无符号整数
            long unsignedNumber = Long.parseLong(binaryString, 2);
            // 将其转换为有符号整数，方法是减去 2^32
            return (int) (unsignedNumber - (1L << 32));
        } else {
            // 否则，直接解释为有符号整数
            return Integer.parseInt(binaryString, 2);
        }
    }


    //循环位移解决
    class Solution{
        public int reverseBits(int n) {
            int res = 0;
            //每次将n的最后一位拼接到res后
            for (int i = 0; i < 32; ++i) {
                res = (res << 1) | (n & 1);
                n >>= 1;
            }
            return res;
        }
    }

    //交换
    class Solution1{
        public int reverseBits(int n) {
            n = (n >> 16) | (n << 16);
            n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
            n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
            n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
            n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
            return n;
        }
    }

    @Test
    public void test(){
        reverseBits(0b11111111111111111111111111111101);
    }


}
