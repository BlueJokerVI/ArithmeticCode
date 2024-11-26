package _013_binary_search;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/earliest-second-to-mark-indices-i/
 */
public class EarliestSecondToMarkIndices {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        long l = 0, r = changeIndices.length;
        for (int i = 0; i < nums.length; i++) {
            l += nums[i];
        }
        l += nums.length;

        //lastT[i] 标记位置i最后出现的时间
        int[] lastT = new int[nums.length];
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(nums, changeIndices, mid, lastT)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return (int) r + 1 > changeIndices.length ? -1 : (int) r + 1;
    }

    boolean check(int[] nums, int[] change, long mid, int[] lastT) {
        Arrays.fill(lastT, -1);
        for (int i = 0; i < mid; i++) {
            lastT[change[i] - 1] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (lastT[i] == -1) {
                return false;
            }
        }

        int cnt = 0;
        for (int i = 0; i < mid; i++) {
            int idx = change[i] - 1;
            if (lastT[idx] == i) {
                if (nums[idx] > cnt) {
                    return false;
                }
                cnt -= nums[idx];
            } else {
                cnt++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        EarliestSecondToMarkIndices t = new EarliestSecondToMarkIndices();
        t.earliestSecondToMarkIndices(new int[]{1, 3}, new int[]{1, 1, 1, 2, 1, 1, 1});
    }
}
