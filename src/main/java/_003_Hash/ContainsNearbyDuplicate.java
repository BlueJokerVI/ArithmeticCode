package _003_Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> has = new HashSet<>();
        int l=0,r=0;
        while (r<nums.length){
            if(r-l<=k){
                if(has.contains(nums[r])){
                    return true;
                }
                has.add(nums[r]);
                r++;
            }else {
                has.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}
