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


    //https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
    public int minOperations(int[] nums) {
        int n = nums.length;
        int t = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                t++;
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
            }
        }
        return nums[n - 2] == 0 || nums[n - 1] == 0 ? -1 : t;
    }


    //https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
    public int minOperations1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                int v = nums[i - 1] - nums[i] + 1;
                ans += v;
                nums[i] += v;
            }
        }
        return ans;
    }

    //https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/
    public int minOperations2(int[] nums) {
        boolean change = false;
        int ans = 0;
        for (int num : nums) {
            if ((num == 0 && !change) || (num == 1 && change)) {
                ans++;
                change = !change;
            }
        }
        return ans;
    }

    //https://leetcode.cn/problems/maximum-number-of-operations-to-move-ones-to-the-end/
    public int maxOperations(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int l = 0;
        int cnt1 = 0;
        int ans = 0;
        while (l < n) {
            if (cs[l] == '0') {
                ans += cnt1;
                //找到下一个1或到达数组末尾
                while (l < n && cs[l] == '0') {
                    l++;
                }
            }
            cnt1++;
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinOperations t = new MinOperations();
        t.maxOperations("00111");
    }

}
