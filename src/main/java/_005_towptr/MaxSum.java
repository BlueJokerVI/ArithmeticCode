package _005_towptr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
