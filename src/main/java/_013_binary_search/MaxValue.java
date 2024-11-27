package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 */
public class MaxValue {
    public int maxValue(int n, int index, int maxSum) {
        long l = 1, r = maxSum;
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (check(n, index, mid, maxSum)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) l - 1;
    }

    boolean check(int n, int index, long mid, int maxSum) {

        long sl = 0;
        // 1 1 1 1 2 3 4 5
        //(mid - index + mid)*(index + 1)/2

        if (mid >= index + 1) {
            sl = (2 * mid - index) * (index + 1) / 2;
        } else {
            sl = (1 + mid) * mid / 2 + (index + 1 - mid);
        }


        //n-1   index+1   len = n-1-index,  mid + mid-n+index
        long sr = 0;
        if (index != n - 1) {
            long v = mid - 1 == 0 ? 1 : mid - 1;

            if (v >= n - 1 - index) {
                sr = (2 * mid - n + index) * (n - 1 - index) / 2;
            } else {
                sr = (1 + v) * v / 2 + (n - 1 - index - v);
            }
        }
        return sl + sr <= maxSum;
    }

    public static void main(String[] args) {
        MaxValue t = new MaxValue();
        t.maxValue(8, 7, 14);
    }

}
