package _013_binary_search;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/
 */
public class MaxNumOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int l = 0, r = n / 2;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(nums, mid)) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    boolean check(int[] nums, int mid) {
        int n = nums.length;
        for (int i = 0; i < mid; i++) {
            //n-1 - x + 1 = mid  x = n-mid
            if (nums[i] * 2 > nums[n - mid + i]) {
                return false;
            }
        }
        return true;
    }


    //双指针
    public int maxNumOfMarkedIndices1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        for (int j = (n + 1) / 2; j < n; j++) {
            // 找到一个匹配
            if (nums[i] * 2 <= nums[j]) {
                i++;
            }
        }
        return i * 2;
    }

}
