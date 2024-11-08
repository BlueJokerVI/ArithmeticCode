package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        //标记偶数位置
        int l = 0;
        //标记奇数位置
        int r = 1;
        int n = nums.length;
        while (l < n && r < n) {
            while (l < n && nums[l] % 2 == 0) {
                l += 2;
            }

            while (r < n && nums[r] % 2 == 1) {
                r += 2;
            }

            if (l < n && r < n) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }

        }
        return nums;
    }
}
