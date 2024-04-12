package _010_dp;

import java.util.Scanner;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://www.acwing.com/problem/content/description/2/
 */
public class _01背包 {
    public static void main(String[] args) {
        int N, V;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        V = scanner.nextInt();

        int[][] goods = new int[N][2];
        for (int i = 0; i < N; i++) {
            goods[i][0] = scanner.nextInt();
            goods[i][1] = scanner.nextInt();
        }

        int[][] dp = new int[N][V + 1];

        /**
         * 递推公式   dp[i][j]  表示0~i的物品放入容量为j的背包内可获取的最大价值
         * 对于物品i，可放可不放 ，dp[i][j] = max(dp[i-1][j],dp[i-1][j-goods[i][0]] + goods[i][1])
         */

        //初始化dp[0][j]
        for(int j=goods[0][0];j<=V;j++){
            dp[0][j] = goods[0][1];
        }


        for(int i=1;i<N;i++){
            for(int j=1;j<=V;j++){
                if(j<goods[i][0]) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-goods[i][0]] + goods[i][1]);
                }
            }
        }

        System.out.printf("%d",dp[N-1][V]);

        return ;
    }


    //一维0，1背包写法
    public static void main1(String[] args) {
        int N, V;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        V = scanner.nextInt();

        int[][] goods = new int[N][2];
        for (int i = 0; i < N; i++) {
            goods[i][0] = scanner.nextInt();
            goods[i][1] = scanner.nextInt();
        }

        int[] dp = new int[V + 1];

        /**
         * dp[j]表示背包容量为j时可获取的最大价值
         * 地推思路和二维是一致的，不过我们发现二维时有 if(j<goods[i][0]) dp[i][j] = dp[i-1][j];  可以通过改变背包容量的便利顺序使dp数组降低一维度，
         * dp[j] = max(dp[j],dp[j-goods[i][0]]+goods[i][1])
         */

        //初始化dp[0]
        dp[0]=0;


        //从第一个物品开始遍历
        for(int i=0;i<N;i++){
            //从后往前遍历防止覆盖类似dp[i-1][j]的结果
            for(int j=V;j>=goods[i][0];j--){
                dp[j] = Math.max(dp[j],dp[j-goods[i][0]]+goods[i][1]);
            }
        }

        System.out.printf("%d",dp[V]);

        return ;
    }
}
