package _001_shuzu;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l =0;
        int r = 0;


        int[] tmp = new int[m+n];
        int index = 0;
        while (l < m && r <n){
            int u = nums1[l];
            int v = nums2[r];
            if(u>v){
                tmp[index++] = v;
                r++;
            }else {
                tmp[index++] = u;
                l++;
            }
        }

        while (l<m){
            tmp[index++] = nums1[l];
            l++;
        }

        while (r<n){
            tmp[index++] = nums2[r];
            r++;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = tmp[i];
        }
    }
}
