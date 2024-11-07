package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
 */
public class NumTriplets {
    public int numTriplets(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long v = (long) nums1[i] * nums1[i];
            int l = 0, r = m - 1;
            while (l < r) {
                long t = (long) nums2[l] * nums2[r];
                if (t == v) {

                    if (nums2[l] == nums2[r]) {
                        int len = r - l + 1;
                        ans += (len * (len - 1)) / 2;
                        break;
                    } else {

                        int x = 1;
                        while (nums2[l] == nums2[l + 1]) {
                            l++;
                            x++;
                        }

                        int y = 1;
                        while (nums2[r] == nums2[r - 1]) {
                            r--;
                            y++;
                        }
                        ans += x * y;
                        r--;
                        l++;
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


        for (int i = 0; i < m; i++) {
            long v = (long) nums2[i] * nums2[i];
            int l = 0, r = n - 1;
            while (l < r) {
                long t = (long) nums1[l] * nums1[r];
                if (t == v) {

                    if (nums1[l] == nums1[r]) {
                        int len = r - l + 1;
                        ans += (len * (len - 1)) / 2;
                        break;
                    } else {

                        int x = 1;
                        while (nums1[l] == nums1[l + 1]) {
                            l++;
                            x++;
                        }

                        int y = 1;
                        while (nums1[r] == nums1[r - 1]) {
                            r--;
                            y++;
                        }
                        ans += x * y;
                        r--;
                        l++;
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


    public static void main(String[] args) {
        NumTriplets x = new NumTriplets();
        x.numTriplets(new int[]{1,1},new int[]{1,1,1});
    }
}
