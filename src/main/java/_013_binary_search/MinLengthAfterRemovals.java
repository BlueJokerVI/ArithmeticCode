package _013_binary_search;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-array-length-after-pair-removals/
 */
public class MinLengthAfterRemovals {


    /**
     * 如果 maxCnt⋅2>n，其余所有 n−maxCnt 个数都要与 x 消除，所以最后剩下 maxCnt⋅2−n 个数。
     * 如果 maxCnt⋅2≤n 且 n 是偶数，那么可以把其余数消除至剩下 maxCnt 个数，然后再和 x 消除，最后剩下 0 个数。
     * 如果 maxCnt⋅2≤n 且 n 是奇数，同上，最后剩下 1 个数。
     */
    public int minLengthAfterRemovals(List<Integer> nums) {

        int v = nums.get(nums.size() / 2);
        int cnt = find(nums, v) - find(nums, v + 1);
        return Math.max(cnt * 2 - nums.size(), nums.size() % 2);
    }

    private int find(List<Integer> nums, int v) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (nums.get(mid) < v) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    //O(nlogn)
    public int minLengthAfterRemovals1(List<Integer> nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        int cur = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (!nums.get(i).equals(nums.get(i - 1))) {
                heap.add(cur);
                cur = 1;
            } else {
                cur++;
            }

            if (i == nums.size() - 1) {
                heap.add(cur);
            }
        }

        int del = 0;
        while (heap.size() >= 2) {
            int v = heap.poll();
            int p = heap.poll();
            v--;
            p--;
            del += 2;
            if (v != 0) {
                heap.add(v);
            }
            if (p != 0) {
                heap.add(p);
            }
        }

        return nums.size() - del;
    }
}
