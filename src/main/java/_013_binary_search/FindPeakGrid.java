package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/find-a-peak-element-ii/
 */
public class FindPeakGrid {

    //https://leetcode.cn/problems/find-a-peak-element-ii/solutions/2571587/tu-jie-li-yong-xing-zui-da-zhi-pan-duan-r4e0n/
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int l = 0, r = n - 1;
        int j = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            j = maxV(mat[mid]);
            if (mid + 1 < n && mat[mid][j] < mat[mid + 1][j]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{l, j};
    }

    int maxV(int[] a) {
        int idx = 0;
        int maxv = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > maxv) {
                maxv = a[i];
                idx = i;
            }
        }
        return idx;
    }


    //https://leetcode.cn/problems/find-peak-element/
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (mid + 1 < n && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
