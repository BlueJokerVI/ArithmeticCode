package _013_binary_search;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Search {


    //法一，查找量尺
    public int search(int[] nums, int target) {
        int index = findMinIndex(nums);
        if(target > nums[nums.length-1]){
            return findTarget(nums,0,index-1,target); //在左段
        }else {
            return findTarget(nums,index,nums.length-1,target); //在右段
        }
    }


    //找出最小元素位置下标
    private int findMinIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 2;
        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[nums.length-1]){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return  l;
    }


    private int findTarget(int[] nums,int l,int r,int target){
        while (l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    //法二，红蓝染色法，查找一次，令target和target右边元素为蓝色，target左边元素为红色
    public int search1(int[] nums, int target) {
       int l = 0;
       int r = nums.length-2;
       while (l<=r){
           int mid = l + (r-l)/2;
           if(isBlue(nums,mid,target)){
               r = mid - 1;
           }else {
               l = mid + 1;
           }
       }
       return nums[l] == target ? l: -1;
    }


    private boolean isBlue(int[] nums,int mid,int target){
        if(nums[mid] > nums[nums.length-1]){
            return target > nums[nums.length-1] && nums[mid] >= target;
        }
        return target > nums[nums.length-1] ||  nums[mid] >= target;
    }


    @Test
    public void test(){
        search(new int[]{4,5,6,7,0,1,2},7);
    }
}
