package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-element-after-decreasing-and-rearranging/
 */
public class MaximumElementAfterDecrementingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - pre > 1) {
                pre++;
            }
        }
        return pre;
    }
}
