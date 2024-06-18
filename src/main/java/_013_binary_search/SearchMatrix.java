package _013_binary_search;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // i, j  ----- > i*n+j

        int l = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = m * n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int i = mid / n;
            int j = mid % n;
            int v = matrix[i][j];
            if (v == target) {
                return true;
            } else if (v > target) {
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test(){
        searchMatrix(new int[][]{{1,2}},2);
    }
}
