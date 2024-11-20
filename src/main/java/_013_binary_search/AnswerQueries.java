package _013_binary_search;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
 */
public class AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (nums[mid] <= queries[i]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            ans[i] = l;
        }
        return ans;
    }
}
