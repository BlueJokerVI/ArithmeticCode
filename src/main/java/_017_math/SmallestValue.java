package _017_math;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/contest/weekly-contest-324/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
 */
public class SmallestValue {


    public void init(boolean[] prime) {
        int n = prime.length;
        boolean[] isPrime = new boolean[n + 1];
        // 线性筛法找出素数
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                prime[i] = true; // 标记素数下标为 true
            }
            for (int j = i * 2; j < n; j += i) {
                isPrime[j] = true;
            }
        }
    }

    public int solve(int n, boolean[] prime) {
        if (prime[n]) {
            return n;
        }

        int cur = n;
        int sum = 0;
        while (!prime[cur]) {
            for (int i = 2; i < cur; i++) {
                if (prime[i] && cur % i == 0) {
                    sum += i;
                    cur /= i;
                    break;
                }
            }
        }
        sum += cur;

        //避免死循环
        if(sum==n){
            return sum;
        }
        return solve(sum, prime);
    }

    public int smallestValue(int n) {
        boolean[] prime = new boolean[n + 1];
        init(prime);
        return solve(n,prime);
    }


    public int smallestValue1(int n) {
        while (true){
           int cur = n;
           int i = 2;
           int sum = 0;
           while (i * i < cur){
               while (cur % i==0){
                   sum += i;
                   cur/=i;
               }
               i++;
           }
           if(cur > 1) sum+=cur;
           if (sum==n) return n;
           n = sum;
        }
    }


}
