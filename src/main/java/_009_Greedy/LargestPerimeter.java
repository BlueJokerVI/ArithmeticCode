package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/largest-perimeter-triangle/description/
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        // a > b > c
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }
}
