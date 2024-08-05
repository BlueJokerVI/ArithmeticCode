package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1 2 3 4 5   // 1 2 3 5 4  // 1 2 4 3 5

        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = n - 1;
        while (i >= 0 && j >= 0 && nums[j] <= nums[i]) {
            j--;
        }

        if (j > i && i>=0) {
            swap(nums, i, j);
            reverse(nums, i + 1, n - 1);
        } else {
            reverse(nums, 0, n - 1);
        }


    }


    void swap(int[] nums, int l, int r) {
        int v = nums[l];
        nums[l] = nums[r];
        nums[r] = v;
    }

    void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
