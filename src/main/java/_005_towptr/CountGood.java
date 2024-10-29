package _005_towptr;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-the-number-of-good-subarrays/
 */
public class CountGood {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        int cur = 0;
        int l = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            int v = cnt.get(nums[i]);
            if (v == 2) {
                cur++;
            }

            if (v > 2) {
                cur = cur - n2(v - 1) + n2(v);
            }

            while (cur >= k) {
                ans += n - i;
                cnt.put(nums[l], cnt.get(nums[l]) - 1);
                int t = cnt.get(nums[l]);
                if (t == 1) {
                    cur--;
                }
                if (t > 1) {
                    cur = cur - n2(t + 1) + n2(t);
                }
                l++;
            }
        }

        return ans;
    }

    int n2(int n) {
        return n * (n - 1) / 2;
    }

}
