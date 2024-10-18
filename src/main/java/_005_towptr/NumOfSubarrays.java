package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */
public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int l = 0;
        int sum = 0;
        int n = arr.length;


        for (int r = 0; r < n; r++) {
            sum += arr[r];
            if (r - l + 1 == k + 1) {
                sum -= arr[l];
                l++;
            }

            if (r - l + 1 == k) {
                double ave = sum * 1.0 / k;
                if (ave > threshold) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
