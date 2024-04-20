package _010_dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://www.acwing.com/problem/content/4/
 */
public class 多重背包问题 {
    public static void main(String[] args) {
        int n,v;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        v = scanner.nextInt();
        List<Integer> weight = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        //转化为01背包问题
        for(int i=0;i<n;i++){
            int w,val,num;
            w = scanner.nextInt();
            val = scanner.nextInt();
            num = scanner.nextInt();

            for(int j=0;j<num;j++){
                weight.add(w);
                value.add(val);
            }
        }

        int[] dp = new int[v+1];
        for(int i=0;i<weight.size();i++){
            for(int j=v;j>=weight.get(i);j--){
                dp[j] = Math.max(dp[j],dp[j-weight.get(i)]+ value.get(i));
            }
        }

        System.out.printf("%d",dp[v]);
    }
}
