package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/h-index-ii/
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int l = 1, r = citations.length;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (citations[citations.length - mid] >= mid) {
                l = mid + 1;
            }
            {
                r = mid - 1;
            }
        }
        return l - 1;
    }

}
