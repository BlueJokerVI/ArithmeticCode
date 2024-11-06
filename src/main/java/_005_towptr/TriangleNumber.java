package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/valid-triangle-number/
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        //外层枚举最长的边
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ans += r - l;
                    r--;
                }else {
                    l++;
                }
            }
        }
        return ans;
    }
}
