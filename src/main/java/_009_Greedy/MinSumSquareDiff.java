package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * <a href="https://leetcode.cn/problems/minimum-sum-of-squared-difference/">...</a>
 */
public class MinSumSquareDiff {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        //多一为留0方便边界处理
        int[] dv = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dv[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(dv);

        int cur = dv[n];
        int index = n - 1;
        long k = k1 + k2;
        int count = 1;
        long ans = 0;

        while (index >= 0 && k >= 0) {
            int m = cur - dv[index];
            long num = (long) m * count;
            if (k >= num) {
                k -= num;
                count++;
                cur = dv[index];
                index--;
            } else {
                while (k >= count) {
                    k -= count;
                    cur--;
                }
                ans = (count - k) * cur * cur + k * (cur - 1) * (cur - 1);
                while (index >= 0) {
                    ans += (long) dv[index] * dv[index];
                    index--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinSumSquareDiff t = new MinSumSquareDiff();
        t.minSumSquareDiff(new int[]{18, 4, 8, 19, 13, 8}, new int[]{18, 11, 8, 2, 13, 15}, 16, 8);
    }
}
