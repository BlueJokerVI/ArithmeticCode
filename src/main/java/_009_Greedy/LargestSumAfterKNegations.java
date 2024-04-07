package _009_Greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {

        //从小到达排序
        Arrays.sort(nums);
        int sum = 0;
        //记录最小非负数
        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(k>0 && nums[i]<0){
                nums[i] = -nums[i];
                k--;
            }
            sum  += nums[i];
            if(nums[i]>=0 && nums[i]<minP){
                minP = nums[i];
            }
        }
        //变化次数消耗完
        if(k==0){
            return sum;
        }
        //k!=0 此时nums内全为正数
        //最小非负数为0，或k是偶数
        if(minP==0 || k%2==0 ){
            return sum;
        }
        return sum - 2*minP;
    }


    @Test
    public void test(){
        int[] nums = new int[]{4,2,3};
        int k = 1;
        largestSumAfterKNegations(nums,k);
    }

}
