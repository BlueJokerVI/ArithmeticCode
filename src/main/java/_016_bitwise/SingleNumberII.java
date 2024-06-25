package _016_bitwise;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    class Solution {
        public int singleNumber(int[] nums) {
        /*
        1.常规思路:HashMap忽略
        2.每个二进制位1的出现次数对3取余,必定为0或1
        试想一下,将所有出现3次的数字放一堆,只出现1次的放一堆
        [1,1,1,3]->[0001,0001,0001,0011]:每个位置的1出现的次数分别为0,0,1,4
        因此,可以遍历所有数字,统计32位中每一位1的出现次数count[i]
        如果是前面一堆的那么必定都是count[i]%3=0,再加入只出现1次的0011,count[0]与count[1]不受影响
        而0011中不为0的位直接对的影响%3的结果,因此将count[i]%3=1的位置为1就是答案
        3.进阶:有限状态自动机(0^a=a,1^a=~a;0&a=0,1&a=a)
        有限状态自动机:00-(1)>01-(1)>10-(1)>00->...满足(num=1改变,num=0保持原状)
        以count[i]%3=0,1,2为状态标定,有三种状态:00,01,10
        设高位为twos,低位为ones,设每次加进来的位为num(0,1)
        ones的分析方法:
        if(twos == 0) {
            if(num == 0) ones = ones;
            if(num == 1) ones = ~ones;
            // 可以合并为:ones = ones ^ num
        }
        if(twos = 1) {
            // 两种状态num=0或1均为0
            ones = 0;
        }
        两种进一步可以合并为:ones = ones ^ num & ~twos
        twos的分析方法类似,不过注意是在ones确定之后进行状态获取的:
        if(ones == 0) {
            if(num == 0) twos = twos;
            if(num == 1) twos = ~twos;
            // 可以合并为:twos = twos ^ num
        }
        if(ones = 1) {
            twos = 0;
        }
        两种进一步可以合并为:twos = twos ^ num & ~ones
        则状态满足ones = ones ^ num & ~twos; twos = twos ^ num & ~ones;
        这是二进制数某位的运算,随着一个个新的num加入,状态机的ones和twos会一直改变,通过两者的组合可得知当前状态
        拓展到32位同理:ones和twos从"1"位的0,1变成"32"位的01
        最后结果count[i]%3=0或1,则(twos,ones)=(0,0)或(0,1)
        从方法2的分析可知,置count[i]=1的位为1就是答案,这里对应(0,1)状态,twos对结果没有作用都为0
        取ones=1的就对应count[i]=1的,而ones本身也是一个"32"位的二进制数,因此直接取ones作为答案就是天然的对应位置1的结果
        */
            int ones = 0, twos = 0;
            for(int num : nums) {
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }


}
