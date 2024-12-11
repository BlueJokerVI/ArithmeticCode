package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/single-element-in-a-sorted-array/
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        //1,1,2,3,3,4,4,8,8
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            boolean find = true;
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                find = false;
            }
            if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                find = false;
            }

            if (find) {
                return nums[mid];
            }

            //往出现一次数组那边靠近，那边数个数一定为奇数
            int lenR = n - mid;
            //1 1 2
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                mid++;
                lenR--;
            }

            if (lenR % 2 == 0) {
                r = n - lenR - 1;
            } else {
                l = mid + 1;
            }

        }

        return nums[l-1];
    }
}
