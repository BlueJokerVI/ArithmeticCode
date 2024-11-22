package _013_binary_search;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/ju-qing-hong-fa-shi-jian/
 */
public class GetTriggerTime {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = requirements.length;
        int m = increase.length;
        int[] ans = new int[n];
        int[][] sum = new int[m + 1][3];
        for (int i = 1; i <= m; i++) {
            sum[i][0] = sum[i - 1][0] + increase[i - 1][0];
            sum[i][1] = sum[i - 1][1] + increase[i - 1][1];
            sum[i][2] = sum[i - 1][2] + increase[i - 1][2];
        }

        for (int i = 0; i < n; i++) {
            int[] t = requirements[i];
            int l = 0, r = m;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (sum[mid][0] < t[0] || sum[mid][1] < t[1] || sum[mid][2] < t[2]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l);
            ans[i] = l == m + 1 ? -1 : l;
        }
        return ans;
    }

    public static void main(String[] args) {
        GetTriggerTime t = new GetTriggerTime();
        t.getTriggerTime(new int[][]{{2, 8, 4}, {2, 5, 0}, {10, 9, 8}}, new int[][]{{2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}});
    }
}
