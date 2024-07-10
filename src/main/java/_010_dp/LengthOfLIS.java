package _010_dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {


    public int lengthOfLIS(int[] nums) {


        if(nums.length==1){
            return 1;
        }

        /**
         * dp[i]表示在0~i下标内以i元素结尾的最长子序列的长度
         * 诺nums[i]大于num[j]就  dp[i] = max(dp[i],dp[j]+1);
         */

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            //还可以用二分优化时间复杂度：https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/?envType=study-plan-v2&envId=top-interview-150
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(ans<dp[i]){
                ans = dp[i];
            }
        }
        return ans;
    }


    public int lengthOfLIS1(int[] nums) {
        /**
         * dp[i][j] 表示在0~i下标内以j元素结尾的最长子序列的长度
         */

        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i][i] = 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i][i] = Math.max(dp[i][i],dp[i-1][j]+1);
                }
                //单纯复制之前结果，直接用一维dp就行o.0
                dp[i][j] = dp[i-1][j];
            }
            if(ans<dp[i][i]){
                ans = dp[i][i];
            }
        }

        return ans;
    }

    @Test
    public void test() {
        int[] s = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS(s);
    }
}
