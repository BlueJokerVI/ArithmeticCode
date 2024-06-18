package _001_shuzu;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-sum-circular-subarray/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        int maxS = Integer.MIN_VALUE; // 最大子数组和，不能为空
        int minS = 0; // 最小子数组和，可以为空
        int maxF = 0, minF = 0, sum = 0;
        for (int x : nums) {
            // 以 nums[i-1] 结尾的子数组选或不选（取 max）+ x = 以 x 结尾的最大子数组和
            maxF = Math.max(maxF, 0) + x;
            maxS = Math.max(maxS, maxF);
            // 以 nums[i-1] 结尾的子数组选或不选（取 min）+ x = 以 x 结尾的最小子数组和
            minF = Math.min(minF, 0) + x;
            minS = Math.min(minS, minF);
            sum += x;
        }
        return sum == minS ? maxS : Math.max(maxS, sum - minS);
    }


    @Test
    public void test() {
        maxSubarraySumCircular(new int[]{1, -2, 3, -2});
    }
}
