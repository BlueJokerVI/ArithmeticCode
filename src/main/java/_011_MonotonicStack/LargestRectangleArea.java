package _011_MonotonicStack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        //l[i]表示heights[i]左边第一个小于heights[i]元素下标
        //r[i]表示heights[i]右边第一个小于heights[i]元素下标
        int[] l = new int[heights.length];
        int[] r = new int[heights.length];
        Arrays.fill(l,-1);
        Arrays.fill(r,heights.length);
        Deque<Integer> s = new ArrayDeque<>();
        for(int i=0;i<heights.length;i++){
            if(s.isEmpty()){
                s.push(i);
                continue;
            }
            while (!s.isEmpty() && heights[i] < heights[s.peek()]){
                r[s.peek()] = i;
                s.pop();
            }
            s.push(i);
        }

        s.clear();
        for(int i=heights.length-1;i>=0;i--){
            if(s.isEmpty()){
                s.push(i);
                continue;
            }
            while (!s.isEmpty() && heights[i] < heights[s.peek()]){
                l[s.peek()] = i;
                s.pop();
            }
            s.push(i);
        }

        for(int i=0;i<heights.length;i++){
            int ll = l[i];
            int rr = r[i];

            int v = (rr-ll-1)*heights[i];
            if(v>ans){
                ans = v;
            }
        }

        return ans;
    }

    @Test
    public void test(){
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
