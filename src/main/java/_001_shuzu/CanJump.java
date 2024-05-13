package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int range = 0;
        for (int i = 0; i <= range && i < nums.length; i++) {
            int tmpRange = i + nums[i];
            if (tmpRange > range) {
                range = tmpRange;
            }
        }
        return range >= nums.length - 1;
    }
}
