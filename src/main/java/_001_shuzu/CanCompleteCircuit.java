package _001_shuzu;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sum = 0;
        int totalSum = 0;

        for(int i=0;i<gas.length;i++){
            sum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                start = i+1;
            }
        }

        if(totalSum < 0){
            return -1;
        }
        return start;
    }


    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<gas.length;i++){
            int rest = gas[i] - cost[i];
            sum += rest;
            if(sum < min){
                min = sum;
            }
        }
        if(sum < 0){
            return -1;
        }
        if(min > 0){
            return 0;
        }
        for(int i = gas.length-1;i>=0;i--){
            min += gas[i] - cost[i];
            if(min >=0){
                return i;
            }
        }
        return -1;
    }
    
    

    @Test
    public void test(){
        canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }

}
