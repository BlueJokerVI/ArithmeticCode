package _005_towptr;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-20  18:23
 * @Description: https://leetcode.cn/problems/3sum/description/
 * 三数之和
 * @Version: 1.0
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int v=1000000;

        //枚举a
        for (int i = 0; i < nums.length; i++) {
            //防止重复
            if(-nums[i]==v){
                continue;
            }
            v = -nums[i];

            //枚举b,c
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

}
