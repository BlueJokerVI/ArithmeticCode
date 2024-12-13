package _009_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 */
public class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        int[][] vidx = new int[n][2];
        for (int i = 0; i < n; i++) {
            vidx[i][0] = nums[i];
            vidx[i][1] = i;
        }

        Arrays.sort(vidx, Comparator.comparingInt(o -> o[0]));
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }

        int cur = 0;
        List<int[]> tmp = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            cur += vidx[i][0];
            tmp.add(vidx[i]);
            if (cur > sum - cur) {
                break;
            }
        }
        return tmp.stream().sorted((a,b)->b[0]-a[0]).map(v -> v[0]).collect(Collectors.toList());
    }
}
