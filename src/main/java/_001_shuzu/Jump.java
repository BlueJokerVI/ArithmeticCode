package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class Jump {
    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int range = nums[0];
        int tmpRange = nums[0];
        int tmpPreIndex = 0;
        int preIndex = 0;
        int ans = 0;
        if (range >= nums.length - 1) {
            return ans;
        }


        while (true) {
            ans++;
            for (int i = preIndex; i <= range; i++) {
                int t = i + nums[i];
                if (t > tmpRange) {
                    tmpRange = t;
                    tmpPreIndex = i;
                }
            }

            if (tmpRange >= nums.length - 1) {
                return ans;
            }

            range = tmpRange;
            preIndex = tmpPreIndex;
        }
    }
}
