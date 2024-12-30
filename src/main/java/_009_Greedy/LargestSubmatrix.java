package _009_Greedy;

import java.util.Arrays;

/**
 * @author cct
 * https://leetcode.cn/problems/largest-submatrix-with-rearrangements/
 */
public class LargestSubmatrix {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //matrix[i][j] 记录位置[i][j]往上数有多少个连续的1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i - 1][j] != 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    break;
                }
                int h = matrix[i][j];
                ans = Math.max(ans, h * (m - j));
            }
        }
        return ans;
    }
}
