package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/
 */
public class MinimumSize {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if(check(nums,mid,maxOperations)){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    boolean check(int[] nums, int mid, int maxOps) {
        int t = 0;
        for (int num : nums) {
            t += num / mid - 1;
            if (num % mid != 0) {
                t++;
            }
            if (t > maxOps) {
                return false;
            }
        }

        return true;
    }
}
