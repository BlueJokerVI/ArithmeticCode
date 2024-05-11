package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int l=2;
        for (int r = 2; r < nums.length; r++) {
            if(nums[r]!=nums[l-2]){
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
