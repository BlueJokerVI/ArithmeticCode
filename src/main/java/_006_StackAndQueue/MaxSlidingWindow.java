package _006_StackAndQueue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-29  17:32
 * @Description: https://leetcode.cn/problems/sliding-window-maximum/
 * 239. 滑动窗口最大值
 * @Version: 1.0
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int index = 0;
        //单调列队
        Deque<Integer> q = new ArrayDeque<>();
        int l=0,r=0;
         while (r < n){


             //维护列队单调性
            while (!q.isEmpty() && nums[r] > nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(r);


             if(r-l+1==k){
                 ans[index++] = nums[q.peekFirst()];
                 if(q.peekFirst()==l){
                     q.removeFirst();
                 }
                 l++;
             }
             r++;
         }
         return ans;
    }

    @Test
    public void test(){
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

}
