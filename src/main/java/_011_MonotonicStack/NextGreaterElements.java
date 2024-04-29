package _011_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/next-greater-element-ii/
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length*2];
        Arrays.fill(ans,-1);
        int[] douNums = new int[nums.length*2];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < douNums.length; i++) {
            douNums[i] = nums[i%nums.length];
        }
        
        for (int i = 0; i<douNums.length;i++) {
            if(s.isEmpty()){
                s.push(i);
                continue;
            }

            while (!s.isEmpty() && douNums[i] > douNums[s.peek()]){
                ans[s.peek()] = douNums[i];
                s.pop();
            }
            s.push(i);
        }


        return Arrays.copyOfRange(ans,0,nums.length);
    }
}
