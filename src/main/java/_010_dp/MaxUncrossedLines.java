package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/uncrossed-lines/
 */
public class MaxUncrossedLines {


    public int maxUncrossedLines(int[] nums1, int[] nums2) {


        /**
         * 两个串中找最长公共字串
         */
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            if(nums2[0]==nums1[i]){
                while (i<nums1.length){
                    dp[i][0] = 1;
                    i++;
                }
            }
        }

        for(int j=0;j<nums2.length;j++){
            if(nums2[j]==nums1[0]){
                while (j<nums2.length){
                    dp[0][j] = 1;
                    j++;
                }
            }
        }

        for(int i=1;i<nums1.length;i++){
            for(int j=1;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }



        return dp[nums1.length-1][nums2.length-1];
    }
}
