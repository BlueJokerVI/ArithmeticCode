package _011_MonotonicStack;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/daily-temperatures/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈，早序列中比每个元素大的下一个元素位置
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();


        for(int i=0;i<temperatures.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void test(){
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

}
