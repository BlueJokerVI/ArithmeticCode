package _001_shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class MajorityElement {


    public int majorityElement(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int maxCnt = 0;
        int ans = nums[0];
        for (int num : nums) {
            int cnt = mp.getOrDefault(num,0)+ 1;
            if(cnt>maxCnt){
                maxCnt = cnt;
                ans = num;
            }
            mp.put(num,cnt);
        }

        return ans;
    }


    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums){
        int vote=0;
        int ans= 1;
        for (int num : nums) {
            if(vote==0){
                ans  = num;
                vote++;
                continue;
            }
            vote += ans==num ? 1 : -1;
        }

        return ans;
    }
}
