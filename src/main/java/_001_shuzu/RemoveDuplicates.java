package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int l=1;
        for (int r = 1; r < nums.length; r++) {
            if(nums[r]!=nums[l-1]){
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
