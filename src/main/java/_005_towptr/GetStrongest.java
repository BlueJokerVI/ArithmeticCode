package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/the-k-strongest-values-in-an-array/
 */
public class GetStrongest {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];

        int[] ans = new int[k];
        int cnt = 0;
        int l = 0, r = n - 1;
        while (l <= r && cnt < k) {
            if (Math.abs(m - arr[l]) <= Math.abs(m - arr[r])) {
                ans[cnt++] = arr[r];
                r--;
            } else {
                ans[cnt++] = arr[l];
                l++;
            }
        }

        return ans;
    }
}
