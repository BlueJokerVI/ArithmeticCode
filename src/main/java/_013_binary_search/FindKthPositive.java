package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/kth-missing-positive-number/
 */
public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        //找到以缺失整数大于等于k的第一个位置
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (count(arr, mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int pre = l - 1 >= 0 ? arr[l - 1] : 0;
        int c = l - 1 >= 0 ? count(arr, l - 1) : 0;
        return pre + k - c;
    }

    int count(int[] arr, int mid) {
        return arr[mid] - (mid + 1);
    }
}
