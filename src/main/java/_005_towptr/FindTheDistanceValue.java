package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/
 */
public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int v : arr1) {
            int left = 0;
            int right = arr2.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr2[mid] >= v) {
                    right = mid; // 收缩右边界
                } else {
                    left = mid + 1; // 收缩左边界
                }
            }
            boolean f = left < arr2.length && Math.abs(arr2[left] - v) <= d;

            if (left - 1 >= 0 && Math.abs(arr2[left - 1] - v) <= d) {
                f = true;
            }

            if (!f) {
                ans++;
            }

        }
        return ans;
    }
}
