package _003_Hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-13  21:33
 * @Description: https://leetcode.cn/problems/two-sum/
 * 1. 两数之和
 * @Version: 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> val = new ArrayList<>();
            val = mp.getOrDefault(nums[i], val);
            val.add(i);
            mp.put(nums[i],val);
        }

        for (int i = 0; i < nums.length; i++) {
            int v = target-nums[i];


            if(mp.containsKey(v)){
                if(v==nums[i]){
                    if (mp.get(v).size()!=2){
                        continue;
                    }
                    ans[0] = mp.get(v).get(0);
                    ans[1] = mp.get(v).get(1);
                    return ans;
                }else {
                    ans[0] = i;
                    ans[1] = mp.get(v).get(0);
                    return ans;
                }
            }
        }

        return ans;
    }


    @Test
    public void test() {
        this.twoSum(new int[]{3,3},6);
    }
}
