package _005_towptr;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/
 */
public class MaxSum {
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        int dif = 0;
        long max = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            dif += !mp.containsKey(nums.get(i)) ? 1 : 0;
            mp.put(nums.get(i), mp.getOrDefault(nums.get(i), 0) + 1);
        }

        if (dif >= m && sum > max) {
            max = sum;
        }

        for (int i = k; i < nums.size(); i++) {

            int r = nums.get(i);
            int l = nums.get(i - k);
            sum += r;
            sum -= l;

            if (mp.get(l) == 1) {
                dif--;
            }
            mp.put(l, mp.get(l) - 1);

            if (!mp.containsKey(r) || mp.get(r) == 0) {
                dif++;
            }
            mp.put(r, mp.getOrDefault(r, 0) + 1);

            if (dif >= m && sum > max) {
                max = sum;
            }
        }
        return max;
    }


    /**
     * https://leetcode.cn/problems/get-the-maximum-score/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int mod = 1000000007;
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                q.offer(i);
            }
        }


        //dp[i][j]表示  i：0表示nums1数组  i：1表示nums2数组  j+1表示到达数组下标为j时的最大得分
        long [][] dp = new long[2][Math.max(n, m) + 1];

        int l = 1, r = 1;
        while (l <= n || r <= m) {
            if (q.isEmpty()) {
                while (l <= n) {
                    dp[0][l] = (dp[0][l - 1] + nums1[l - 1]);
                    l++;
                }
                while (r <= m) {
                    dp[1][r] = dp[1][r - 1] + nums2[r - 1];
                    r++;
                }
            } else {
                int v = q.poll();

                while (nums1[l - 1] != v) {
                    dp[0][l] = dp[0][l - 1] + nums1[l - 1];
                    l++;
                }

                while (nums2[r - 1] != v) {
                    dp[1][r] = dp[1][r - 1] + nums2[r - 1];
                    r++;
                }
                dp[0][l] = Math.max(dp[0][l - 1], dp[1][r - 1]) + v;
                dp[1][r] = Math.max(dp[1][r - 1], dp[0][l - 1]) + v;
                l++;
                r++;
            }
        }

        return (int) (Math.max(dp[0][n], dp[1][m]) % mod);
    }


    public static void main(String[] args) {
        MaxSum t = new MaxSum();
        t.maxSum(new int[]{2,4,5,8,10},new int[]{4,6,8,9});
    }
}
