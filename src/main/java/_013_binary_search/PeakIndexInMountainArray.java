package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (mid < arr.length && arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
