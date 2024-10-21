package _005_towptr;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sliding-subarray-beauty/
 */
public class GetSubarrayBeauty {


    //滑动窗口 + 堆 + 懒删除
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> (a - b));
        PriorityQueue<Integer> big = new PriorityQueue<>((a, b) -> (b - a));
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length, t;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            big.offer(nums[i]);
            if (big.size() > x)
                small.offer(big.poll());
        }
        res[0] = (t = big.peek()) < 0 ? t : 0;
        for (int i = k; i < n; i++) {
            boolean p = nums[i - k] <= big.peek();//删除的元素是否在左边
            mp.put(nums[i - k], mp.getOrDefault(nums[i - k], 0) + 1);
            while (!big.isEmpty() && mp.getOrDefault(t = big.peek(), 0) > 0) {
                mp.put(t, mp.get(t) - 1);
                big.poll();
            }
            while (!small.isEmpty() && mp.getOrDefault(t = small.peek(), 0) > 0) {
                mp.put(t, mp.get(t) - 1);
                small.poll();
            }
            boolean q = big.isEmpty() || nums[i] > big.peek();//是否在右边新加元素
            if (p && q) {
                //左边删右边加
                small.offer(nums[i]);
                big.offer(small.poll());
                res[i - k + 1] = (t = big.peek()) < 0 ? t : 0;
            } else if (p && !q) {
                //左边删左边加
                big.offer(nums[i]);
                res[i - k + 1] = (t = big.peek()) < 0 ? t : 0;
            } else if (!p && q) {
                //右边删，右边加
                small.offer(nums[i]);
                res[i - k + 1] = (t = big.peek()) < 0 ? t : 0;
            } else if (!p && !q) {
                //右边删左边加
                big.offer(nums[i]);
                small.offer(big.poll());
                while (mp.getOrDefault(t = big.peek(), 0) > 0) {
                    mp.put(t, mp.get(t) - 1);
                    big.poll();
                }
                res[i - k + 1] = (t = big.peek()) < 0 ? t : 0;
            }
        }
        return res;
    }


    //滑动窗口 + 暴力枚举
    public int[] getSubarrayBeauty1(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int l = 0;
        int[] cnt = new int[101];
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i] + 50]++;
        }

        for (int i = k - 1; i < n; i++) {
            cnt[nums[i] + 50]++;
            int count = 0;
            for (int j = 0; j < 50; j++) {
                count += cnt[j];
                if (count == x) {
                    ans[i - k] = j - 50;
                    break;
                }
            }
            cnt[nums[i - k] + 50]--;
        }

        return ans;
    }

    public static void main(String[] args) {

        GetSubarrayBeauty getSubarrayBeauty = new GetSubarrayBeauty();
        getSubarrayBeauty.getSubarrayBeauty(new int[]{-1, -2, -3, -4, -5}, 2, 2);
    }
}
