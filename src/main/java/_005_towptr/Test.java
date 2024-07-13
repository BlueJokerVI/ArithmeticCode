package _005_towptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class Test {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;


        //先从左往右找0值
        while (l < nums.length && r < nums.length) {
            while (l < nums.length && nums[l] != 0) {
                l++;
            }
            //从l后开始找非0值
            r = l + 1;
            while (r < nums.length && nums[r] == 0) {
                r++;
            }

            if (r < nums.length) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
    }


    public int maxArea(int[] height) {
        // (l-r)*min(height[l],height[r])

        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int cur = (l-r)*Math.min(height[l],height[r]);
            if(cur > ans) ans = cur;

            if(height[l] < height[r]){
                int v = height[l];
                //找更高的
                while (l < r && height[l] <= v){
                    l++;
                }
            }else if(height[l] > height[r]){
                int v = height[r];
                //找更高的
                while (l < r && height[r] <= v){
                    r--;
                }
            }else {
                int ll = height[l];
                int rr = height[r];
                while (l < r && height[l] <= ll){
                    l++;
                }
                while (l < r && height[r] <= rr){
                    r--;
                }
            }

        }
        return ans;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int v=1000000;
        for (int i = 0; i < nums.length; i++) {
            //防止重复
            if(-nums[i]==v){
                continue;
            }
            v = -nums[i];

            int l = i+1,r = nums.length - 1;
            while (l<r){
                if(nums[l] + nums[r] > v){
                    r--;
                }else if(nums[l] + nums[r] < v){
                    l++;
                }else {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[l]);
                    t.add(nums[r]);
                    ans.add(t);
                    //防止重复
                    int cv = nums[l];
                    while (l< nums.length && nums[l]==cv){
                        l++;
                    }
                    cv = nums[r];
                    while (r>=0 && nums[r]==cv){
                        r--;
                    }
                }
            }
        }
        return  ans;
    }


    public int trap(int[] height) {

        int n = height.length;
        //l[i]记录height[i]左边最高值 ,r[i]记录height[i]右边最高的值
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = Integer.MIN_VALUE;
        int maxV = l[0];
        for (int i = 1; i < n; i++) {
            if(height[i-1] > maxV){
                maxV = height[i-1];
            }
            l[i] = maxV;
        }
        r[0] = Integer.MIN_VALUE;
        maxV = r[0];
        for(int i=n-2;i>=0;i--){
            if(height[i-1] > maxV){
                maxV = height[i-1];
            }
            r[i] = maxV;
        }

        int ans = 0;
        for (int i = 1; i < n-1; i++) {
            ans += Math.max(Math.min(l[i],r[i]) - height[i],0);
        }
        return ans;
    }
}
