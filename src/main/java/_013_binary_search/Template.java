package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class Template {
    int binarySearch(int[] nums, int target) {
        //都是闭区间[]
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    int binarySearch1(int[] nums, int target) {
        //区间[)
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    int binarySearch2(int[] nums, int target) {
        //区间()
        int l = -1;
        int r = nums.length;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
