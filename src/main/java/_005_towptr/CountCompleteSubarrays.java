package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-complete-subarrays-in-an-array/
 */
public class CountCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[2001];
        int dif = 0;
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] == 1) {
                dif++;
            }
        }
        cnt = new int[2001];
        int t = 0;
        int ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] == 1) {
                t++;
            }

            while (t == dif) {
                ans += n - i;
                cnt[nums[l]]--;
                if (cnt[nums[l]] == 0) {
                    t--;
                }
                l++;
            }
        }
        return ans;
    }
}
