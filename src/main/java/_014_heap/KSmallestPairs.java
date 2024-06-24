package _014_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/?envType=study-plan-v2&envId=top-interview-150
 */
public class KSmallestPairs {


    //内存溢出o.0
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt((list) -> {
            int v1 = list[0];
            int v2 = list[1];
            return v1 + v2;
        }));
        for (int i : nums1) {
            for (int j : nums2) {
                heap.add(new int[]{i,j});
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (k-- > 0){
            int[] poll = heap.poll();
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(poll[0]);
            integers.add(poll[1]);
            ans.add(integers);
        }

        return ans;
    }

    //堆+多路并归
    class Solution {
        boolean flag = true;
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int n = nums1.length, m = nums2.length;
            //小优化让小数组在前
            if (n > m && !(flag = false)) return kSmallestPairs(nums2, nums1, k);
            List<List<Integer>> ans = new ArrayList<>();
            PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
            for (int i = 0; i < Math.min(n, k); i++) q.add(new int[]{i, 0});
            while (ans.size() < k && !q.isEmpty()) {
                int[] poll = q.poll();
                int a = poll[0], b = poll[1];
                ans.add(new ArrayList<Integer>(){{
                    add(flag ? nums1[a] : nums2[b]);
                    add(flag ? nums2[b] : nums1[a]);
                }});
                if (b + 1 < m) q.add(new int[]{a, b + 1});
            }
            return ans;
        }
    }

}
