package _010_dp;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/last-stone-weight-ii/
 */
public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int v =0;
        for (int stone : stones) {
            v += stone;
        }

        int sum = v;
        v /=2;

        //因为最后一块石头重量要最小，所以将两堆石头总量要尽可能接近 sum(总重量)/2
        //令石头的重量为stones[i] 价值也为stones[i]  背包容量 v
        /**
         * 进一步分析：要让差值小,两堆石头的重量都要接近sum/2;我们假设两堆分别为A,B,A<sum/2,B>sum/2,若A更接近sum/2,B也相应更接近sum/2
         * 进一步转化：将一堆stone放进最大容量为sum/2的背包,求放进去的石头的最大重量MaxWeight,最终答案即为sum-2*MaxWeight;、
         */
        int[] dp = new int[v+1];

        for(int i=0;i<stones.length;i++){
            for(int j=v;j>=stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }


        //在计算v的时候，v = sum / 2 因为是向下取整，所以sum - dp[v] 一定是大于等于dp[v]的。
        return (sum-dp[v]) - dp[v];
    }


    //暴力回溯也行
    int res = Integer.MAX_VALUE;
    int path = 0;
    public int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for(int i: stones)
            sum+=i;
        path = sum/2;
        backtracking(stones, 0);
        int flag = 0;
        if(sum % 2==1)
            flag=1;
        return res*2+flag;
    }
    public void backtracking(int[] stones, int index){
        res = Math.min(res, Math.abs(path));
        if(path <= 0)
            return;
        for(int i=index; i<stones.length && res!=0; i++){
            path-=stones[i];
            backtracking(stones, i+1);
            path+=stones[i];
        }
    }
}
