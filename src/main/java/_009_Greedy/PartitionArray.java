package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int m = nums[i] + k;
            while (i < n && nums[i] <= m) {
                i++;
            }
            ans++;
            i--;
        }
        return ans;
    }
}
