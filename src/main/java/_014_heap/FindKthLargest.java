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

    //快速选择法
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums,0,nums.length-1,k);
        }

        public int quickSelect(int[] nums, int l, int r, int k) {

            int left = l;
            int right = r;

            Random random = new Random();
            int x = l + random.nextInt(r - l + 1);
            int pivot = nums[x];
            nums[x] = nums[l];

            while (l < r) {
                while (l < r && nums[r] >= pivot) {
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && nums[l] <= pivot) {
                    l++;
                }
                nums[r] = nums[l];
            }
            nums[l] = pivot;

            //比pivot大的个数为right - l ,找到第k大的元素
            if (k - 1 == right - l) {
                return pivot;
            }

            if (k <= right - l) {
                return quickSelect(nums, l + 1, right, k);
            } else {
                return quickSelect(nums, left, l - 1, k - (right - l + 1));
            }

        }
    }

    //建堆法
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildMaxHeap(nums, heapSize);
            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
                swap(nums, 0, i);
                --heapSize;
                maxHeapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        public void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2; i >= 0; --i) {
                maxHeapify(a, i, heapSize);
            }
        }

        public void maxHeapify(int[] a, int i, int heapSize) {
            int l = i * 2 + 1, r = i * 2 + 2, largest = i;
            if (l < heapSize && a[l] > a[largest]) {
                largest = l;
            }
            if (r < heapSize && a[r] > a[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(a, i, largest);
                maxHeapify(a, largest, heapSize);
            }
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }


}
