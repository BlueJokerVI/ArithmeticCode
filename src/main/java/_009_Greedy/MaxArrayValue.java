package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/
 */
public class MaxArrayValue {
    public long maxArrayValue(int[] nums) {
        //2,3,7,9,3
        int n = nums.length;
        long ans = 0;
        long later = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (later >= nums[i]) {
                later += nums[i];
            } else {
                later = nums[i];
            }
            ans = Math.max(ans, later);
        }
        return ans;
    }
}
