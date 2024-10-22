package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
public class MinSwaps {
    public int minSwaps(int[] nums) {
        int len = 0;
        for (int num : nums) {
            if (num == 1) {
                len++;
            }
        }

        if (len == 0) {
            return 0;
        }

        int n = nums.length;
        //n-1 - l + 1 = len  l = n-len
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int l = n - len;
        for (int i = l; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
            }
        }
        min = cnt;

        for (int r = 0; r < n - 1; r++) {
            if (nums[l] == 0) {
                cnt--;
            }
            l = (l + 1) % n;
            if (nums[r] == 0) {
                cnt++;
            }

            if (cnt < min) {
                min = cnt;
            }
        }

        return min;
    }
}
