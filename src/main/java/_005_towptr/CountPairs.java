package _005_towptr;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/
 */
public class CountPairs {
    public int countPairs(List<Integer> nums, int target) {
        int[] arr = nums.stream().mapToInt(v -> v).toArray();
        int l = 0, r = arr.length - 1;
        Arrays.sort(arr);
        int ans = 0;
        while (l < r) {
            if (arr[l] + arr[r] < target) {
                ans += r - l - 2;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
