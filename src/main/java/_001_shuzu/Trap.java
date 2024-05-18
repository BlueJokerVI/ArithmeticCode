package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
 */
public class Trap {
    public int trap(int[] height) {

        //l[i]表示height[i]左边最高的高度
        int[] l = new int[height.length];
        int[] r = new int[height.length];

        int h = height[0];
        l[0] = -1;
        r[height.length-1] = -1;
        for(int i=1;i<l.length;i++){
            if(height[i-1] > h){
                h = height[i-1];
            }
            l[i] = h;
        }

        h = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            if(height[i+1]>h){
                h = height[i+1];
            }
            r[i] = h;
        }

        int ans = 0;
        for(int i=1;i<height.length-1;i++){
            if(l[i]>height[i] && r[i]>height[i]){
                ans += Math.min(l[i],r[i]) - height[i];
            }
        }
        return ans;
    }
}
