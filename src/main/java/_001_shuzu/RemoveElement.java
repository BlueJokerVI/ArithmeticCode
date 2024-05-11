package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int l=0;
        for (int r = 0; r < nums.length; r++) {
            if(nums[r]!=val) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
