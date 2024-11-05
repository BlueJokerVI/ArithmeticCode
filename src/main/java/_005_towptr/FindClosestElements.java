package _005_towptr;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-k-closest-elements/
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        //n-1 - x + 1 = k        x = n-k
        if (x >= arr[n - 1]) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[n - k + i]);
            }
            return ans;
        }
        int l = 0, r = n;
        while (r - l + 1 > k) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                r--;
            } else {
                l++;
            }
        }

        while (l <= r) {
            ans.add(arr[l]);
            l++;
        }
        return ans;
    }
}
