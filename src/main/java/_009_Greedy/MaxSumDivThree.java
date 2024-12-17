package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/
 */
public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        dp[0][nums[0] % 3] = nums[0];
        for (int i = 1; i < n; i++) {

            switch (nums[i] % 3) {
                case 0:
                    dp[i][0] = dp[i - 1][0] + nums[i];
                    if (dp[i - 1][1] % 3 == 1) {
                        dp[i][1] = dp[i - 1][1] + nums[i];
                    }
                    if (dp[i - 1][2] % 3 == 2) {
                        dp[i][2] = dp[i - 1][2] + nums[i];
                    }
                    break;
                case 1:
                    if (dp[i - 1][2] % 3 == 2) {
                        dp[i][0] = dp[i - 1][2] + nums[i];
                    }
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i][0]);

                    dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + nums[i]);

                    if (dp[i - 1][1] % 3 == 1) {
                        dp[i][2] = dp[i - 1][1] + nums[i];
                    }
                    dp[i][2] = Math.max(dp[i][2], dp[i - 1][2]);
                    break;
                case 2:
                    if (dp[i - 1][1] % 3 == 1) {
                        dp[i][0] = dp[i - 1][1] + nums[i];
                    }
                    dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);

                    if (dp[i - 1][2] % 3 == 2) {
                        dp[i][1] = dp[i - 1][2] + nums[i];
                    }
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][1]);

                    dp[i][2] = Math.max(dp[i][0] + nums[i], dp[i - 1][2]);
                    break;
                default:
            }
        }
        return dp[n - 1][0];
    }


    public static void main(String[] args) {
        MaxSumDivThree t = new MaxSumDivThree();
        t.maxSumDivThree(new int[]{1, 2, 3, 4, 4});
    }
}
