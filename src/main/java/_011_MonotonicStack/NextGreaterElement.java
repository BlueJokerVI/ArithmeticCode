package _011_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/next-greater-element-i/
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> mp = new HashMap<>();
        Deque<Integer> s = new ArrayDeque<>();

        for(int i=0;i<nums2.length;i++){
            if(s.isEmpty()){
                s.push(i);
                continue;
            }

            while (!s.isEmpty() && nums2[i] > nums2[s.peek()]){
                mp.put(nums2[s.peek()],nums2[i]);
                s.pop();
            }
            s.push(i);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = mp.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
