package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        int[] cp = Arrays.copyOf(nums, n);
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n && nums[i] <= nums[i + 1]) {
                ans1 += nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            }
            if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
                ans1 += nums[i-1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
            }
        }

        for (int i = 1; i < n; i += 2) {
            if (i + 1 < n && cp[i] <= cp[i + 1]) {
                ans2 += cp[i + 1] - cp[i] + 1;
                cp[i + 1] = cp[i] - 1;
            }
            if (i - 1 >= 0 && cp[i] <= cp[i - 1]) {
                ans2 += cp[i-1] - cp[i] + 1;
                cp[i - 1] = cp[i] - 1;
            }
        }

        return Math.min(ans2, ans1);
    }

    public static void main(String[] args) {
        MovesToMakeZigzag t = new MovesToMakeZigzag();
        t.movesToMakeZigzag(new int[]{7,4,8,9,7,7,5});
    }
}
