package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-average-subarray-r/
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double max = -100000;
        double cur = 0;
        double subSum = 0;
        int l = 0;
        int n = nums.length;
        for (int r = 0; r < n; r++) {
            subSum += nums[r];
            if (r - l + 1 == k + 1) {
                subSum -= nums[l];
                l++;
            }

            if (r - l + 1 == k) {
                cur = subSum / k;
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        findMaxAverage.findMaxAverage(new int[]{-1},1);
    }

}
