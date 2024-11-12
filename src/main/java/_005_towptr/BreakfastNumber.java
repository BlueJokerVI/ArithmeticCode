package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/2vYnGI/
 */
public class BreakfastNumber {

    //二分
    public int breakfastNumber(int[] staple, int[] drinks, int x) {

        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int mod = 1000000007;
        for (int s : staple) {
            int v = x - s;

            int l = 0, r = drinks.length - 1;
            // 0 2
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (drinks[mid] <= v) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            ans = (ans + l) % mod;
        }
        return ans;
    }


    //两数之和思想
    public int breakfastNumber1(int[] staple, int[] drinks, int x) {

        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int mod = 1000000007;
        int l = 0, r = drinks.length - 1;
        int m = staple.length;
        while (l < m && r >= 0) {
            if (staple[l] + drinks[r] <= x) {
                ans = (ans + r) % mod;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }


    //hash

    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        int[] cnt = new int[x];
        for (int i : staple) {
            if(i<x){
                cnt[i]++;
            }

        }
        for (int i = 1; i < x; i++) {
            cnt[i] += cnt[i - 1];
        }

        int ans = 0;
        int mod = 1000000007;
        for (int drink : drinks) {
            int v = x - drink;
            if (v > 0) {
                ans = (ans + cnt[v]) % mod;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        BreakfastNumber t = new BreakfastNumber();
        t.breakfastNumber(new int[]{6, 1, 9, 2, 9, 9, 3, 4}, new int[]{2, 7, 10, 2, 9, 2, 1, 3}, 2);
    }
}
