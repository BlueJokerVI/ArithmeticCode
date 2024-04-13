package _010_dp;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/target-sum/
 */
public class FindTargetSumWays {

    int v = 0;
    int ans = 0;

    public int findTargetSumWays1(int[] nums, int target) {

        dfs(0, nums, target);
        return ans;
    }


    //暴力回溯
    void dfs(int index, int[] nums, int target) {
        if (index == nums.length) {
            if (v == target) {
                ans++;
            }
            return;
        }

        int cur = nums[index];

        v += cur;
        dfs(index + 1, nums, target);
        v -= 2 * cur;
        dfs(index + 1, nums, target);

    }


    public int findTargetSumWays(int[] nums, int target) {

        /**
         * 诺在nums前添加+，-号最终可以得出target，有left - right = target（left是nums前加+的元素和，right是nums前加-的元素和）
         * 有 left+right=sum   left = target + sum - left
         * 有 left = (target + sum )/2
         *
         * 诺 left%2==1  return 0 无法得出target
         * 且 abs(target) > sum   return
         *
         * 问题转化为物品nums[i]放入容量为left的背包内，恰好装满的次数
         */

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = target + sum;
        if (left % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        left /= 2;

        //dp[i][j] 序列0~i在j容量下填满的情况有多少中
        //dp[i][j] =  dp[i - 1][j] + dp[i - 1][j - nums[i]];
        int[][] dp = new int[nums.length][left + 1];

        //初始化dp
        for (int j = 0; j <= left; j++) {
            if (j == nums[0]) {
                dp[0][j] = 1;
            }
        }
        /**
         * 这样考虑，容量为0，在下标为0的元素选择，填满的情况就有两种
         * 1.nums[0] = 0 此时填埋满的情况为2种，nums[0]放或不放都可以。
         * 2.nums[0] !=0 此时填满的情况也为1种，nums[0]不放入背包。
         */
        dp[0][0] = 1;


        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= left; j++) {
                if (j < nums[i]) {
                    //i元素放不下
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //i元素放的下
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length-1][left];
    }



    //dp压缩下
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = target + sum;
        if (left % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        left /= 2;


        int[] dp = new int[left+1];

        //dp[j] = dp[j] + dp[j-num[i]]

        //初始化dp,因为不放入任何一个元素dp[0]的容量恰好是0 所以dp[0] = 1;
        dp[0] = 1;

        for(int i=0;i<nums.length;i++){
            for(int j=left;j>=nums[i];j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }

        return dp[left];
    }




    @Test
    public void test(){
        int[] nums = new int[]{1,1,1,1,1};
        findTargetSumWays(nums,3);
    }

}
