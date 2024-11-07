package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/3sum-with-multiplicity/
 */
public class ThreeSumMulti {

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = 0;
        int n = arr.length;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int v = target - arr[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int t = arr[l] + arr[r];
                if (t == v) {
                    if (arr[l] == arr[r]) {
                        int len = r - l + 1;
                        ans = (ans + len * (len - 1) / 2 % mod) % mod;
                        break;
                    } else {
                        int x = 1;
                        while (arr[l] == arr[l + 1]) {
                            l++;
                            x++;
                        }
                        int y = 1;
                        while (arr[r] == arr[r - 1]) {
                            r--;
                            y++;
                        }
                        ans = (ans + x * y % mod) % mod;
                        l++;
                        r--;
                    }
                }
                if (t < v) {
                    l++;
                }
                if (t > v) {
                    r--;
                }
            }
        }
        return ans;
    }
}
