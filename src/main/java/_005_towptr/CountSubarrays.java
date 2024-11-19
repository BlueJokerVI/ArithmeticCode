package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/
 */
public class CountSubarrays {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int t = 0;
        int n = nums.length;
        long ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                t++;
            }
            while (t == k) {
                ans += n - i;
                if (nums[l] == max) {
                    t--;
                }
                l++;
            }
        }
        return ans;
    }


    /**
     * <a href="https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/">...</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (l <= r && sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }


    //https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length;
        int bound = -1;
        int minI = -1;
        int maxI = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == minK) {
                minI = i;
            }
            if (nums[i] == maxK) {
                maxI = i;
            }
            if (nums[i] > maxK || nums[i] < minK) {
                bound = i;
                maxI = i;
                minI = i;
            } else {
                if (minI >= 0 && maxI >= 0 && nums[maxI] == maxK && nums[minI] == minK) {
                    ans += Math.min(maxI, minI) - bound;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubarrays t = new CountSubarrays();
        t.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
    }

}
