package _005_towptr;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/continuous-subarrays/
 */
public class ContinuousSubarrays {

    //堆 + 滑动窗口
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int l = 0, r = 0; r < n; r++) {
            minQ.add(nums[r]);
            maxQ.add(nums[r]);
            while (Math.abs(minQ.peek() - maxQ.peek()) > 2) {
                maxQ.remove(nums[l]);
                minQ.remove(nums[l]);
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }


    // 红黑树 + 滑动窗口， 应为最大最小之差小于等于二，最多维护3个数，插入删除可视为O(1)
    public long continuousSubarrays1(int[] nums) {
        int n = nums.length;
        long ans = 0;
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for (int l = 0, r = 0; r < n; r++) {
            t.merge(nums[r], 1, Integer::sum);
            while (t.lastKey() - t.firstKey() > 2) {
                int k = nums[l++];
                if(t.get(k)==1){
                    t.remove(k);
                }else {
                    t.merge(k,-1,Integer::sum);
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        ContinuousSubarrays continuousSubarrays = new ContinuousSubarrays();
        continuousSubarrays.continuousSubarrays(new int[]{1358, 1359, 1358, 1357, 1358, 1359, 1358, 1357, 1358, 1357, 1358, 1357, 1357, 1358, 1359, 1358, 1359, 1359, 1359, 1358, 1357, 1356, 1356, 1356, 1355, 1356, 1356, 1357, 1358, 1359, 1360, 1360, 1360, 1359, 1359, 1360, 1361, 1362, 1363, 1362, 1361, 1361, 1360, 1360, 1361, 1361, 1361, 1362, 1361, 1362});
    }
}
