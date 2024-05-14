package _001_shuzu;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] ans = new int[n];

        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i-1]*nums[i-1];
        }
        r[n-1] = 1;
        for(int i= n-2;i>=0;i--){
            r[i] = r[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
            ans[i] = l[i]*r[i];
        }

        return ans;

    }


    //优化空间复杂度
    public int[] productExceptSelf1(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1]*nums[i-1];
        }
        int tmp = 1;
        for(int i= n-2;i>=0;i--){
            tmp = tmp * nums[i+1];
            ans[i] = ans[i] * tmp;
        }
        return ans;
    }
}
