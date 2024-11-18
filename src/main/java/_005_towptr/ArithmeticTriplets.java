package _005_towptr;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-arithmetic-triplets/
 */
public class ArithmeticTriplets {

    //hash
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int[] cnt = new int[251];
        for (int num : nums) {
            cnt[num] = 1;
        }

        for (int num : nums) {
            if (cnt[num + diff] == 1 && cnt[num + 2 * diff] == 1) {
                ans++;
            }
        }
        return ans;
    }


    //3指针
    public int arithmeticTriplets1(int[] nums, int diff) {
        int ans = 0;
        int l = 0, m = 1;
        for (int rv : nums) {
            while (nums[m] + diff < rv){
                m++;
            }
            if(nums[m] + diff > rv){
                continue;
            }
            while (nums[l] + 2*diff < rv){
                l++;
            }
            if(nums[l] + 2*diff == rv){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArithmeticTriplets t = new ArithmeticTriplets();
        t.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3);
    }
}
