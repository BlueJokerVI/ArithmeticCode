package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/split-array-largest-sum/
 */
public class SplitArray {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(nums, mid,k)) {
                r = mid - 1;
            } else  {
                l = mid + 1;
            }
        }

        return r + 1;
    }

    boolean check(int[] nums, int mid,int k) {
        int t = 0;
        int cur = 0;

        for (int num : nums) {
            cur += num;
            if (cur > mid) {
                cur = num;
                t++;
            }

            if (cur == mid) {
                t++;
                cur = 0;
            }
        }

        if (cur != 0) {
            t++;
        }

        return t <= k;
    }


    public static void main(String[] args) {
        SplitArray t = new SplitArray();
        t.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
    }
}
