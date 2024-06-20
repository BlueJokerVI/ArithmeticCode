package _014_heap;

import java.util.*;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add(num);
        }

        k--;
        while (k-- > 0) {
            heap.poll();
        }
        return heap.poll();

    }

    public class Solution {
        private int quickSelect(List<Integer> nums, int k) {
            // 随机选择基准数
            Random rand = new Random();
            int pivot = nums.get(rand.nextInt(nums.size()));
            // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
            List<Integer> big = new ArrayList<>();
            List<Integer> equal = new ArrayList<>();
            List<Integer> small = new ArrayList<>();
            for (int num : nums) {
                if (num > pivot)
                    big.add(num);
                else if (num < pivot)
                    small.add(num);
                else
                    equal.add(num);
            }
            // 第 k 大元素在 big 中，递归划分
            if (k <= big.size())
                return quickSelect(big, k);
            // 第 k 大元素在 small 中，递归划分
            // x y z
            if (nums.size() - small.size() < k)
                //s + e + b = n
                //  k - b - e = k + s -n
                return quickSelect(small, k - nums.size() + small.size());
            // 第 k 大元素在 equal 中，直接返回 pivot
            return pivot;
        }

        public int findKthLargest(int[] nums, int k) {
            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }
            return quickSelect(numList, k);
        }
    }


    class Solution1 {
        int quickselect(int[] nums, int l, int r, int k) {
            if (l == r) return nums[k];
            int x = nums[l], i = l - 1, j = r + 1;
            while (i < j) {
                do i++; while (nums[i] < x);
                do j--; while (nums[j] > x);
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            if (k <= j) return quickselect(nums, l, j, k);
            else return quickselect(nums, j + 1, r, k);
        }

        public int findKthLargest(int[] _nums, int k) {
            int n = _nums.length;
            return quickselect(_nums, 0, n - 1, n - k);
        }
    }


}
