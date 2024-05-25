package _001_shuzu;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (r<nums.length){
            int v = nums[r];
            r++;

            if(r== nums.length){
                ans.add(getS(nums[l],v));
            }

            if(r<nums.length && nums[r]-1!=v){
                ans.add(getS(nums[l],v));
                l = r;
            }
        }
        return ans;
    }
    String getS(int a,int b){
        if(a==b){
            return ""+a;
        }
        return a+"->"+b;
    }
}
