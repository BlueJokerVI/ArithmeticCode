package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-common-value/
 */
public class GetCommon {
    public int getCommon(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        int n1 = nums1.length, n2 = nums2.length;
        while (l < n1 && r < n2) {
            if (nums1[l] == nums2[r]) {
                return nums1[l];
            }

            if (nums1[l] < nums2[r]) {
                l++;
            } else {
                r++;
            }
        }
        return -1;
    }
}
