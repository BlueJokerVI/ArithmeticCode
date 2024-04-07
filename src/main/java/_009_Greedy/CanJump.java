package _009_Greedy;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/jump-game/
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }

        //记录可达的最大下标值
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if(i>maxIndex){
                return false;
            }

            int v = i+nums[i];

            if(v>maxIndex){
                maxIndex = v;
                if(maxIndex >= nums.length-1){
                    return true;
                }
            }
        }

        return false;
    }
}
