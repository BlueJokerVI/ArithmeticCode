package _009_Greedy;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/wiggle-subsequence/
 * 波动数组一般
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1){
            return 1;
        }

        //存放nums[i] - nums[i-1]
        int[] dif = new int[nums.length-1];

        for (int i = 1; i < nums.length; i++) {
            dif[i-1] = nums[i] - nums[i-1];
        }

        
        //找到第一个差值为正和差值为负数的值
        int p = -1;
        int n = -1;
        for (int i = 0; i < dif.length; i++) {
            if(n!=-1 && p!=-1){
                break;
            }
            if(p==-1 && dif[i]>0){
                p = i;
                continue;
            }
            if(n==-1 && dif[i] < 0){
                n = i;
            }
        }

        //所有元素值一样
        if(p==-1 && n== -1){
            return 1;
        }

        //dif 单调
        if(p==-1 || n==-1){
          return 2;
        }

        int ans = 1;
        int cnt = 1;


        int pre = dif[p];
        //第一个元素为正数时，波动序列长度
        cnt = getDif(dif, p, cnt, pre);
        pre = dif[n];
        //第一个元素为负数时，波动序列长度
        ans = getDif(dif, n, ans, pre);

        //+1是因为返回子序列的长度
        return Math.max(ans, cnt)+1;

    }

    private int getDif(int[] dif, int n, int ans, int pre) {
        for (int i = n+1;i<dif.length;i++){
            if(pre>0 && pre + dif[i] < pre){
                ans++;
                pre = dif[i];
            }

            if(pre<0 && pre + dif[i] > pre){
                ans++;
                pre = dif[i];
            }
        }
        return ans;
    }


    /**
     * dp解法
     * @param nums
     * @return
     */
    public int wiggleMaxLength1(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度
        int dp[][] = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++){
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;

            for (int j = 0; j < i; j++){
                if (nums[j] > nums[i]){
                    // i 是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (nums[j] < nums[i]){
                    // i 是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }



    @Test
    public void test(){
        int nums[]  = new int[] {1,7,4,9,2,5};
        wiggleMaxLength(nums);
    }

}
