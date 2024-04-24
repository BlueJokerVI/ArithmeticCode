package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;

        //dp[i][j]  表示0-i中nums1以i结尾的数组与0-j中以j结尾的最长公共序列的长度
        // if(nums2[j]==nums1[0])   dp[i][j] = dp[i - 1][j - 1] + 1;  666666

        int[][] dp = new int[nums1.length][nums2.length];
        
        //初始化
        for(int i=0;i< nums1.length;i++){
            if(nums2[0]==nums1[i]){
                dp[i][0] = 1;
                result = 1;
            }
        }

        for(int j=0;j< nums2.length;j++){
            if(nums2[j]==nums1[0]){
                dp[0][j] = 1;
                result = 1;
            }
        }
        
        
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }

        return result;
    }
}
