package _005_towptr;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/smallest-difference-lcci/
 */
public class SmallestDifference {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int m = b.length;
        int l = 0, r = 0;

        long ans = Math.abs((long) a[l] - b[r]);

        int pre;
        //标记pre的值取值那个数组
        boolean lr = false;
        if (a[l] < b[r]) {
            pre = a[l];
            l++;
            lr = true;
        } else {
            pre = b[r];
            r++;
            lr = false;
        }

        while (l < n && r < m) {
            if (a[l] < b[r]) {
                if (!lr && Math.abs((long) pre - a[l]) < ans) {
                    ans = Math.abs((long)pre - a[l]);
                }
                pre = a[l];
                l++;
                lr = true;
            } else {

                if (lr && Math.abs((long)pre - b[r]) < ans) {
                    ans = Math.abs((long)pre - b[r]);
                }
                pre = b[r];
                r++;
                lr = false;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        SmallestDifference t = new SmallestDifference();
        t.smallestDifference(new int[]{-2147483648,1}, new int[]{2147483647,0});
    }
}
