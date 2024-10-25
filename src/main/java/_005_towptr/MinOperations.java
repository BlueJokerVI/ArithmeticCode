package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int cur = 0;
        int l = 0;
        int r = n - 1;
        int min = Integer.MAX_VALUE;
        // 1,1,4,2,3,1,1,4,2,3

        for (; l < n; l++) {
            cur += nums[l];
            if (cur >= x) {
                if (cur == x) {
                    min = l + 1;
                }
                cur -= nums[l];
                l--;
                break;
            }
        }

        if(l==n){
            return -1;
        }

        while (true) {
            if (cur < x) {
                if (r < 0) {
                    break;
                }
                cur += nums[r];
                r--;
            } else {
                //l+1  + (n-1 - (r+1) + 1) = l +n-r
                if (cur == x && l + n - r < min) {
                    min = l + n - r;
                }

                if (l >= 0) {
                    cur -= nums[l];
                    l--;
                } else {
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }






    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        minOperations.minOperations(new int[]{1, 1}, 3);
    }
}
