package _015_sort;

import org.junit.Test;

import java.util.Random;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class QuickSort {

    //快排，挖坑法
    void sort(int[] nums ,int l,int r){

        int left = l;
        int right = r;

        if(l>=r){
            return;
        }
        Random random = new Random();
        //随机选取基准
        int x = l + random.nextInt(r-l+1);
//        int pivot = nums[l];
        int pivot = nums[x];
        //且将基准先移到首个元素位置方便后序填坑操作
        nums[x] = nums[l];
        nums[l] = pivot;

        while (l<r){
            while (l<r && nums[r] >= pivot){
                r--;
            }
            nums[l] = nums[r];

            while (l<r && nums[l] <= pivot){
                l++;
            }
            nums[r] = nums[l];
        }
        //放好基准元素
        nums[l] = pivot;
        sort(nums,left,l-1);
        sort(nums,l+1,right);
    }


    @Test
    public void test(){
    int[] arr = new int[]{7,5,3,11,-2};
        sort(arr,0,4);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
