package _003_Hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-12  19:17
 * @Description: https://leetcode.cn/problems/intersection-of-two-arrays/description/
 * 349. 两个数组的交集
 * @Version: 1.0
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[1024];
        int[] cnt2 = new int[1024];
        List<Integer> ans = new ArrayList<>();

        for (int i : nums1) {
            if (cnt1[i] == 0) {
                cnt1[i] = 1;
            }
        }

        for (int i : nums2) {
            if (cnt2[i] == 0) {
                cnt2[i] = 1;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            if (cnt2[i] == cnt1[i] && cnt1[i] == 1) {
                ans.add(i);
            }
        }


        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[1024];
        int[] cnt2 = new int[1024];
        List<Integer> ans = new ArrayList<>();

        for (int i : nums1) {
            cnt1[i]++;
        }

        for (int i : nums2) {
            cnt2[i]++;
        }


        for (int i = 0; i <= 1000; i++) {
            if (cnt2[i]!=0&&cnt1[i]!=0) {
                int t = Math.min(cnt2[i],cnt1[i]);
                for (int j = 0; j < t; j++) {
                    ans.add(i);
                }

            }
        }


        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    @Test
    public void  test(){
        this.intersection1(new int[]{1,2,2,1},new int[]{2,2});
    }
}
