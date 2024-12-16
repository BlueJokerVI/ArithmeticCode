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

    //https://leetcode.cn/problems/find-polygon-with-the-largest-perimeter/
    public long largestPerimeter1(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        for (int v : nums) {
            sum += v;
        }

        for (int i = n - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i]) {
                return sum;
            }
        }
        return -1;
    }
}
