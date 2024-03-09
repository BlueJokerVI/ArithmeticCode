package _005_towptr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-21  20:47
 * @Description: https://leetcode.cn/problems/4sum/
 * 18. 四数之和
 * @Version: 1.0
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans  = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {

            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < len; j++) {

                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int l = len-1;
                long cVal = target - nums[i] - nums[j];
                for (int k = j+1; k < len; k++) {

                    if(k>j+1&&nums[k]==nums[k-1]){
                        continue;
                    }

                    while (k<l && nums[l]+nums[k] > cVal){
                        l--;
                    }

                    if(k>=l){
                        break;
                    }

                    if(nums[l]+nums[k]==cVal){
                        ArrayList<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[k]);
                        tmpList.add(nums[l]);
                        ans.add(tmpList);
                    }


                }

            }

        }

        return ans;
    }


    @Test
    public void Test(){
//        this.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);
        int a = 1000000000;

        System.out.println((long)-294967296 - 2*a);
        System.out.println(Integer.MAX_VALUE);
    }
}
