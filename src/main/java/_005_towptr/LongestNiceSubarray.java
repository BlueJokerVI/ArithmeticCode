package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-nice-subarray/
 */
public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        //每位上1出现的次数
        int[] bits = new int[40];
        int ans = 0;

        for (int l = 0, r = 0; r < n; r++) {
            int v = nums[r];
            int index = 0;
            while (v > 0) {
                bits[index] += v % 2;
                while (l < r && bits[index] == 2) {
                    ds(bits, nums[l]);
                    l++;
                }
                v /= 2;
                index++;
            }
            if (r - l + 1 > ans) {
                ans = r - l + 1;
            }
        }
        return ans;
    }


    public int longestNiceSubarray1(int[] nums) {
        int ans = 1, n = nums.length;
        int res = nums[0];
        for (int l = 0, r = 1; r < n; r++) {
            while ((res & nums[r]) > 0) {
                res ^= nums[l];
                l++;
            }
            res |= nums[r];
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public int longestNiceSubarray2(int[] nums) {
        int ans = 0;
        for (int left = 0, right = 0, or = 0; right < nums.length; right++) {
            while ((or & nums[right]) > 0) // 有交集
                or ^= nums[left++]; // 从 or 中去掉集合 nums[left]
            or |= nums[right]; // 把集合 nums[right] 并入 or 中
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


    private void ds(int[] bits, int v) {
        int index = 0;
        while (v > 0) {
            bits[index++] -= v % 2;
            v /= 2;
        }
    }
}
