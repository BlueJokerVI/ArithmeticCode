package _005_towptr;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxArea {


    public int maxArea(int[] height) {

        int ans = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;

        while (l < r){
            if(height[l] > height[r] ){
                int s = height[r] * (r - l);
                if(s > ans){
                    ans = s;
                }
                r--;
            }else {
                int s = height[l]*(r-l);
                if(s>ans){
                    ans = s;
                }
                l++;
            }
        }
        return ans;
    }

    private int getS(int[] height, int m, int n) {
        return (n - m) * Math.min(height[m], height[n]);
    }


    @Test
    public void test(){
        maxArea(new int[]{2,3,4,5,18,17,6});
    }
}
