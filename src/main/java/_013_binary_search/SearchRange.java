package _013_binary_search;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = find(nums,target);
        if(l== nums.length || nums[l]!=target){
            return new int[]{-1,-1};
        }
        int r = find(nums,target+1) - 1;
        return new int[]{l,r};
    }


    //二分查找返回下标,target出现的第一个位置
    int find(int[] nums,int target){
        int l = 0;
        //1 2 3   1
        int r = nums.length-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return r;
    }

    @Test
    public void test(){
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
