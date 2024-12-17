package _009_Greedy;

/**
 * @author cct
 * https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 */
public class MinOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (!can(n, m)) {
            return -1;
        }

        int[] cnt = new int[6];
        int d = 0;
        for (int v : nums1) {
            d += v;
        }
        for (int v : nums2) {
            d -= v;
        }

        if (d > 0) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            d = -d;
        }

        for (int i : nums1) {
            cnt[6 - i]++;
        }
        for (int i : nums2) {
            cnt[i - 1]++;
        }

        if (d == 0) {
            return 0;
        }


        int t = 0;
        for (int i = 5; i >= 1; i--) {
            int v = cnt[i];
            for (int j = 1; j <= v; j++) {
                d += i;
                t++;
                if (d >= 0) {
                    return t;
                }
            }
        }
        return -1;
    }

    boolean can(int n, int m) {
        if (n < m) {
            return n * 6 >= m;
        } else {
            return m * 6 >= n;
        }
    }

    public static void main(String[] args) {
        MinOperations t = new MinOperations();
        t.minOperations(new int[]{6, 6}, new int[]{1});
    }

}
