package _013_binary_search;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindMin {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        //3 1 2   3 2 1
        while (l<=r ){
            int mid = l+(r-l)/2;
            if(mid-1>=0 && nums[mid] < nums[mid-1] &&  mid +1 < nums.length && nums[mid]<nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else {
                r = mid-1;
            }
        }
        return  nums[l];
    }

    public int findMin1(int[] nums) {
        int l = 0;
        int r = nums.length - 2;
        while (l<=r ){
            int mid = l+(r-l)/2;
            if(nums[mid] > nums[nums.length-1]){
                l = mid + 1;
            }else {
                r = mid-1;
            }
        }
        return  nums[l];
    }
    @Test
    public void test() {
        findMin(new int[]{4,5,6,7,0,1,2});
    }
}
