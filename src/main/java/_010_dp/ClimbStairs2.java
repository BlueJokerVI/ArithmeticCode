package _010_dp;

import java.util.Scanner;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://kamacoder.com/problempage.php?pid=1067
 */
public class ClimbStairs2 {
    public static void main(String[] args) {
        int m,n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        //问题相当与有一个容量为n的背包，有m中物品，将其恰好装满的排列有多少种，每种物品都可以装多次
        //dp[j] = dp[j] + dp[j-i]
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
                if(j>=i){
                    dp[j] = dp[j] + dp[j-i];
                }
            }
        }
        System.out.printf("%d",dp[n]);
    }
}
