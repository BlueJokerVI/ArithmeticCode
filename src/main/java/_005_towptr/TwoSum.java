package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l<r){
            if(numbers[l] + numbers[r] > target){
                r--;
            }else if(numbers[l] + numbers[r] < target){
                l++;
            }else {
                return new int[]{l+1,r+1};
            }
        }

        //不会执行到这
        return new int[]{0,0};
    }
}
