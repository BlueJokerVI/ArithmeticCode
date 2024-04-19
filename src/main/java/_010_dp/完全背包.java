package _010_dp;

import java.util.Scanner;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://www.acwing.com/problem/content/3/
 */
public class 完全背包 {
    public static void main(String[] strings){
        int n,v;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        v = scanner.nextInt();
        int[][] dp = new int[n][v+1];
        int[] value = new int[n];
        int[] cost = new int[n];


        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        //dp[i][j] =  max(dp[i-1][j],dp[i][j-cost[i]] + value[i])

        //初始化dp[0][j]
        for(int j=cost[0];j<=v;j++) {
            dp[0][j] = dp[0][j - cost[0]] + value[0];
        }

         for(int i=1;i<n;i++){
             for(int j=0;j<=v;j++){
                 if(j<cost[i]){
                     dp[i][j] = dp[i-1][j];
                 }else{
                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-cost[i]] + value[i]);
                 }
             }
         }
        System.out.printf("%d",dp[n-1][v]);
    }


    /**
     * 压缩数组版
     */
    public void package1(){
        int n,v;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        v = scanner.nextInt();
        int[] dp = new int[v+1];
        int[] value = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        //先遍历物品、再遍历背包容量
        for(int i=0;i<n;i++){
            for(int j=cost[i];j<=v;j++){
                dp[j] = Math.max(dp[j],dp[j-cost[i]]+value[i]);
            }
        }
// 纯背包问题遍历物品和遍历背包的容量没有关系
//        for(int j=1;j<=v;j++){
//            for(int i=0;i<n;i++){
//                if(cost[i]>j){
//                    continue;
//                }
//                dp[j] = Math.max(dp[j],dp[j-cost[i]]+value[i]);
//            }
//        }


        System.out.printf("%d",dp[v]);

        return;
    }
}
