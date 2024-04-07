package _009_Greedy;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-subarray/
 *
 *  暴力解法就是枚举子序列的起始点和结束点，时间复杂度：n^2
 *
 *  优化枚举子序列的起始点
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int tmpV = nums[0];
        for (int i = 1; i < nums.length; i++) {

            //tmpV为某段子序列的和，当其为负时，便可以让起始点更新为当前节点。
            if(tmpV<0 ){
                tmpV = nums[i];
            }else {
                tmpV += nums[i];
            }

            if(ans < tmpV){
                ans = tmpV;
            }
        }
        return ans;
    }

    /**
     * 1.dp[i]:以num[i]结尾的子序列和最大值
     * 2.递推公式 dp[i] = max (dp[i-1]+nums[i],nums[i])          res = max(res,dp[i])
     * 3.初始化 都为 0
     * 4.遍历方向，从前往后
     * 5.举例推导结果。。。
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        System.out.println("dp[0]: "+dp[0]);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            System.out.printf("dp[%d]: %d\n",i,dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray1(nums);
    }
}
