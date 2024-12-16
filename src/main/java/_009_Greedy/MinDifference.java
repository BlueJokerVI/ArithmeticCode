package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinDifference {
    public int minDifference(int[] nums) {

        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(nums[n - 1] - nums[3],
                Math.min(nums[n - 2] - nums[2],
                        Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0])));
    }
}
