package _005_towptr;

import java.util.HashMap;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 */
public class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;
        int cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            cnt += !mp.containsKey(nums[i]) ? 1 : 0;
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        if (cnt == k && sum > max) {
            max = sum;
        }

        for (int i = k; i < nums.length; i++) {
            int l = nums[i - k];
            int r = nums[i];
            sum += r;
            sum -= l;

            if (mp.get(l) == 1) {
                cnt--;
            }
            mp.put(l, mp.get(l) - 1);

            if (!mp.containsKey(r) || mp.get(r) == 0) {
                cnt++;
            }
            mp.put(r, mp.getOrDefault(r, 0) + 1);

            if (cnt == k && sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
