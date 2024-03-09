package _003_Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @CreateTime: 2023-12-14  21:08
 * @Description: https://leetcode.cn/problems/4sum-ii/
 * 454. 四数相加 II
 * @Version: 1.0
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int ans = 0;

        int len = nums1.length;
        Map<Integer,Integer> cnt = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int v1 = nums1[i]+nums2[j];
                cnt.put(v1,cnt.getOrDefault(v1,0)+1);
            }
        }


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int v1 = -(nums3[i]+nums4[j]);
                if (cnt.containsKey(v1)){
                    ans+=cnt.get(v1);
                }
            }
        }




        return ans;
    }
}
