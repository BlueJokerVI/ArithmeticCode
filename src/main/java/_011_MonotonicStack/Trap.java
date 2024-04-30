package _011_MonotonicStack;

import org.junit.Test;

import javax.print.attribute.standard.MediaName;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/trapping-rain-water/
 */
public class Trap {
    //单调栈解法
    public int trap(int[] height) {

        if (height.length <= 2) {
            return 0;
        }

        int b = 0;
        Deque<Integer> s = new ArrayDeque<>();
        int ans = 0;
        s.push(0);

        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[s.peek()]) {
                while (!s.isEmpty() && height[i] > height[s.peek()]) {
                    int mid = s.pop();
                    if(!s.isEmpty()){
                        int h = Math.min(height[s.peek()], height[i]) - height[mid];
                        int w = i - s.peek() - 1;
                        ans += Math.max(h * w, 0);
                    }
                }
                s.push(i);
            } else if (height[i] == height[s.peek()]) {
                s.pop();
                s.push(i);
            } else {
                s.push(i);
            }
        }

        return ans;
    }


    //双指针解法
    public int trap1(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        //一列一列的算

        // l[i]记录height[i]左边最高高度,r[i]记录右边
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        for(int i=1;i<height.length;i++){
            l[i] = Math.max(l[i-1],height[i-1]);
        }

        for(int i=height.length-2;i>=0;i--){
            r[i] = Math.max(height[i+1],r[i+1]);
        }
        int ans = 0;
        for(int i=1;i<height.length-1;i++){
            int v = Math.min(r[i],l[i]) - height[i];
            ans += Math.max(0,v);
        }
        return ans;
    }


    @Test
    public void test() {
        trap(new int[]{4, 2, 0, 3, 2, 5});
    }
}
