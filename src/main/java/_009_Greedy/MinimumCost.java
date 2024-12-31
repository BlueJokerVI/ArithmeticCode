package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 */
public class MinimumCost {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return ans + min1 + min2;
    }


    //https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount/
    public int minimumCost1(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        int n = cost.length;
        int t = 0;
        for (int i = n - 1; i >= 0; i--) {
            t++;
            if (t == 3) {
                t = 0;
            } else {
                ans += cost[i];
            }
        }
        return ans;
    }

    //https://leetcode.cn/problems/minimum-cost-to-make-all-characters-equal/solutions/2286922/yi-ci-bian-li-jian-ji-xie-fa-pythonjavac-aut0/
    public long minimumCost(String s) {
        //010101
        //110101   1
        //000101   2
        //111101   3
        //111110   2
        //111111   1

        char[] cs = s.toCharArray();
        int ans = 0;
        int n = cs.length;
        for (int i = 1; i < n; i++) {
            if (cs[i] != cs[i - 1]) {
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }


    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = 0;
        int j = 0;
        while (i < m - 1 || j < n - 1) {
            if (j == n - 1 || i < m - 1 && horizontalCut[i] < verticalCut[j]) {
                // 上下连边
                ans += (long) horizontalCut[i++] * (n - j);
            } else {
                // 左右连边
                ans += (long) verticalCut[j++] * (m - i);
            }
        }
        return ans;
    }


    public long minimumCost1(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int[] preH = new int[m];
        for (int i = 0; i < m - 1; i++) {
            preH[i + 1] = preH[i] + horizontalCut[i];
        }
        int[] preV = new int[n];
        for (int i = 0; i < n - 1; i++) {
            preV[i + 1] = preV[i] + verticalCut[i];
        }

        long ans = 0;
        int l = m - 2;
        int r = n - 2;

        if (l < 0) {
            return preV[n - 1];
        }

        if (r < 0) {
            return preH[m - 1];
        }

        while (l >= 0 && r >= 0) {
            if (horizontalCut[l] > verticalCut[r]) {
                ans += horizontalCut[l];
                ans += preV[r + 1];
                l--;
                if (l < 0) {
                    ans += preV[r + 1];
                }
            } else {
                ans += verticalCut[r];
                ans += preH[l + 1];
                r--;
                if (r < 0) {
                    ans += preH[l + 1];
                }
            }
        }

        return ans;
    }


}
