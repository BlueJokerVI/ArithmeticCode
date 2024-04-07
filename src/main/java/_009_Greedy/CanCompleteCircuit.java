package _009_Greedy;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/gas-station/
 * 题解：https://programmercarl.com/0134.%E5%8A%A0%E6%B2%B9%E7%AB%99.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 */
public class CanCompleteCircuit {



    //解法1

    /**
     * 使车从0作为出发点，计算最难过的点min
     * 1.诺sum<0 说明总的油耗大于可使用的油耗，不存在某点可以绕一周
     * 2.诺min>=0 说明每个节点都可以过 0就可以为出发点
     * 3.诺min<0  即从后往前加油，使min>=0,即最难过的点都过了，全局也可以过，该点就是起点
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }

        if (sum < 0) return -1;
        if (min >= 0) return 0;

        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) return i;
        }

        return -1;
    }


    //解法2
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            //每当curSum < 0 时说明这段路内的加油站都不能为起点，应为总的油耗大于可使用的油耗
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }


    @Test
    public void test(){
        int[] gas = new int[]{5,5,1,3,4};
        int[] cost = new int[]{8,1,7,1,1};


        canCompleteCircuit(gas,cost);
    }
}
