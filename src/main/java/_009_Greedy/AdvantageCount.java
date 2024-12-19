package _009_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cct
 * https://leetcode.cn/problems/advantage-shuffle/
 */
public class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {

        int n = nums1.length;

        int[] soucre = Arrays.copyOf(nums1, n);
        int[] ans = new int[n];
        int[] vis = new int[n];
        Arrays.fill(ans, -1);

        int[][] nmp = new int[n][2];
        for (int i = 0; i < n; i++) {
            nmp[i][0] = nums2[i];
            nmp[i][1] = i;
        }
        Arrays.sort(nmp, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(nums1);

        int l = 0, r = 0;


        while (r < n) {
            while (r < n && nums1[r] <= nmp[l][0]) {
                r++;
            }

            if (r < n) {
                ans[nmp[l][1]] = nums1[r];
                vis[r] = 1;
                l++;
                r++;
            }
        }

        int s = 0, a = 0;

        while (s < n) {
            while (s < n && vis[s] == 1) {
                s++;
            }
            while (a < n && ans[a] != -1) {
                a++;
            }
            if (s == n || a == n) {
                break;
            }
            ans[a] = nums1[s];
            a++;
            s++;
        }

        return ans;
    }

    public static void main(String[] args) {
        AdvantageCount a = new AdvantageCount();
        a.advantageCount(new int[]{5621, 1743, 5532, 3549, 9581}, new int[]{913, 9787, 4121, 5039, 1481});
    }
}
