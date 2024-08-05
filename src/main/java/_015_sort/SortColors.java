package _015_sort;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sort-colors/?envType=study-plan-v2&envId=top-100-liked
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            //找1、2
            while (l < nums.length && nums[l] == 0) {
                l++;
            }

            //找0
            while (r >= 0 && (nums[r] == 1 || nums[r] == 2)) {
                r--;
            }

            if (l < r && nums[l] > nums[r]) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }

        }

        r = nums.length - 1;
        l = 0;
        while (l< nums.length && nums[l]==0){
            l++;
        }
        while (l < r) {
            while (l < nums.length && nums[l] == 1) {
                l++;
            }

            while (r >= 0 && nums[r] == 2) {
                r--;
            }

            if (l < r) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }
    }

    @Test
    public void test(){
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
