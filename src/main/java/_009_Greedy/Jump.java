package _009_Greedy;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/jump-game-ii/
 */
public class Jump {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        //记录当前这步可达的范围
        int curRange = nums[0];
        //记录前一步最大可达的范围
        int preRange = nums[0];
        int step = 0;
        if(preRange >= nums.length-1){
            return step;
        }
        for (int i = 1; i < nums.length; i++) {
            if(i<=preRange && i+nums[i] > curRange){
                curRange = i+nums[i];
            }
            //前一步最大可达的返回走完，更新preRange
            if(i==preRange){
                preRange = curRange;
                step++;
                if(curRange >= nums.length-1){
                    return step;
                }
            }
        }
        //程序不会执行到这
        return 0;
    }
}
