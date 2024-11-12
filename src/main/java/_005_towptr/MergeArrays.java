package _005_towptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/
 */
public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (l < n1 && r < n2) {
            if (nums1[l][0] == nums2[r][0]) {
                ans.add(Arrays.asList(nums1[l][0], nums1[l][1] + nums2[r][1]));
                l++;
                r++;
                continue;
            }

            if (nums1[l][0] < nums2[r][0]) {
                ans.add(Arrays.asList(nums1[l][0],nums1[l][1]));
                l++;
            } else {
                ans.add(Arrays.asList(nums2[r][0],nums2[r][1]));
                r++;
            }
        }

        while (l < n1) {
            ans.add(Arrays.asList(nums1[l][0], nums1[l][1]));
            l++;
        }

        while (r < n2) {
            ans.add(Arrays.asList(nums2[r][0], nums2[r][1]));
            r++;
        }
        return ans.stream().map(list -> list.stream().mapToInt(v->v).toArray()).toArray(int[][]::new);
    }


    //优化写法
    public int[][] mergeArrays1(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<int[]> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (l < n1 && r < n2) {
            if (nums1[l][0] == nums2[r][0]) {
                ans.add(new int[]{nums1[l][0], nums1[l][1] + nums2[r][1]});
                l++;
                r++;
                continue;
            }

            if (nums1[l][0] < nums2[r][0]) {
                ans.add(new int[]{nums1[l][0],nums1[l][1]});
                l++;
            } else {
                ans.add(new int[]{nums2[r][0],nums2[r][1]});
                r++;
            }
        }

        while (l < n1) {
            ans.add(new int[]{nums1[l][0], nums1[l][1]});
            l++;
        }

        while (r < n2) {
            ans.add(new int[]{nums2[r][0], nums2[r][1]});
            r++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
