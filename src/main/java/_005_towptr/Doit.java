package _005_towptr;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: 做做过的题目
 */
public class Doit {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int v=1000000;

        //枚举a
        for (int i = 0; i < nums.length; i++) {
            //防止重复
            if(-nums[i]==v){
                continue;
            }
            v = -nums[i];

            //枚举b,c
            int l = i+1,r = nums.length - 1;
            while (l<r){
                if(nums[l] + nums[r] > v){
                    r--;
                }else if(nums[l] + nums[r] < v){
                    l++;
                }else {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[l]);
                    t.add(nums[r]);
                    ans.add(t);
                    int cv = nums[l];
                    while (l< nums.length && nums[l]==cv){
                        l++;
                    }
                    cv = nums[r];
                    while (r>=0 && nums[r]==cv){
                        r--;
                    }
                }
            }
        }
        return  ans;
    }


    @Test
    public void test(){
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
