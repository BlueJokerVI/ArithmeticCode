package _010_dp;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/ones-and-zeroes/
 */
public class FindMaxForm {


    public int findMaxForm(String[] strs, int m, int n) {

        // 0-i dp[i][j][k]    strs[i] 价值1  体积 l,r

        //dp[i][j][k] = max(dp[i-1][j][k], dp[i-1][j-l][k-r])

        // dp[j][k] = max(dp[j][k], dp[j-l][k-r] )
        int[][] dp = new int[m+1][n+1];

        int[][] mn = new int[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            mn[i] = getMN(strs[i]);
        }


        for(int i=0;i<strs.length;i++){
            for(int j=m;j>=mn[i][0];j--){
                for(int k=n;k>=mn[i][1];k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j-mn[i][0]][k-mn[i][1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    int[] getMN(String s){
        int n=0;
        int m=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                n++;
            }else {
                m++;
            }
        }
        return new int[]{m,n};
    }
}
