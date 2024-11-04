package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-number-of-nice-subarrays/
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;

        int nk = 0;
        int nk1 = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] % 2 == 1) {
                cnt++;
            }
            while (cnt == k) {
                nk += n - r;
                if (nums[l] % 2 == 1) {
                    cnt--;
                }
                l++;
            }

        }

        cnt = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] % 2 == 1) {
                cnt++;
            }
            while (cnt == k + 1) {
                nk1 += n - r;
                if (nums[l] % 2 == 1) {
                    cnt--;
                }
                l++;
            }
        }
        return nk - nk1;
    }


    public int numberOfSubarrays1(int[] nums, int k) {
        int[] prefixCnt = new int[nums.length + 1];

        //prefixCnt[x]记录x出现次数
        prefixCnt[0] = 1;
        int res = 0;
        //统计奇数的个数
        int sum = 0;

        //遍历每个数，每次固定滑动窗口right，通过prefixCnt[sum - k]统计left的可选值
        for (int num : nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }
}
