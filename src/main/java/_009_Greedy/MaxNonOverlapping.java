package _009_Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class MaxNonOverlapping {

    //维护上一次区间尾指针
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int end = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - target)) {
                if (mp.get(sum - target) + 1 > end) {
                    ans++;
                    end = i;
                }
            }
            mp.put(sum, i);
        }
        return ans;
    }

    public int maxNonOverlapping1(int[] nums, int target) {
        final HashSet<Integer> set = new HashSet<>();
        set.add(target);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum)) {
                set.clear();
                count++;
            }
            set.add(sum + target);
        }
        return count;
    }
}
