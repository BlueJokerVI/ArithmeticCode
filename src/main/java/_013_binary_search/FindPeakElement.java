package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-peak-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindPeakElement {

    // 1 2 3
    public int findPeakElement(int[] nums) {
        int l=0;
        //避免数组越界情况
        int r=nums.length - 2;
        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[mid+1]){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
