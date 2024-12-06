package _013_binary_search;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 */
public class SmallestDistancePair {

    //给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
    //返回所有数对距离中第 k 小的数对距离。
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0, r = 1000000;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(nums, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    //是否至少有k个数小于 mid
    boolean check(int[] nums, int mid, int k) {

        int n = nums.length;
        int t = 0;

        //1 2 3
        int l = 0, r = 1;
        //同向双指针
        while (l < n) {
            while (r < n && nums[r] - nums[l] <= mid) {
                r++;
            }
            t += r - l - 1;
            l++;
        }
        return t >= k;
    }


    public static void main(String[] args) {
        SmallestDistancePair t = new SmallestDistancePair();
        t.smallestDistancePair(new int[]{9, 10, 7, 10, 6, 1, 5, 4, 9, 8}, 18);
    }
}
