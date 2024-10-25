package _005_towptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-the-longest-equal-subarray/
 */
public class LongestEqualSubarray {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int[] arr = nums.stream().mapToInt(v -> v).toArray();
        int n = arr.length;
        int[] cnt = new int[n + 1];
        int max = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt[arr[i]]++;
            if (cnt[arr[i]] > max && i - l + 1 - cnt[arr[i]] <= k) {
                max = cnt[arr[i]];
            }

            while (i - l + 1 - max > k) {
                cnt[arr[l]]--;
                l++;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        LongestEqualSubarray longestEqualSubarray = new LongestEqualSubarray();
        longestEqualSubarray.longestEqualSubarray(Arrays.asList(1,3,2,3,1,3),3);
    }
}
