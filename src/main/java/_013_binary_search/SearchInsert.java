package _013_binary_search;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-interview-150
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // 2,4,6       3,5
        while (l <= r) {
            //int mid = l + (r-l)/2;  //防止l+r溢出
            int mid = (l + r)/ 2;
            int v = nums[mid];
            if (v == target) {
                return mid;
            } else if (v < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    @Test
    public void test() {
        searchInsert(new int[]{1, 3}, 0);
    }
}
