package _013_binary_search;

/**
 * @author cct
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (check(matrix, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }


    //O(nlogn)
    boolean check(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int t = 0;
        for (int[] ints : matrix) {
            if (ints[n - 1] <= mid) {
                t += n;
            } else {
                int l = 0, r = n - 1;
                while (l <= r) {
                    int idx = (r - l) / 2 + l;
                    if (ints[idx] <= mid) {
                        l = idx + 1;
                    } else {
                        r = idx - 1;
                    }
                }
                t += Math.max(0, l);
            }

            if (t >= k) {
                return true;
            }
        }
        return false;
    }

    //O(n) 写法从左下角开始遍历
    boolean check1(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int t = 0;
        int x = n - 1, y = 0;
        while (x >= 0 && y < n) {
            while (x >= 0 && matrix[x][y] > mid) {
                x--;
            }
            t += x + 1;
            y++;
        }
        return t >= k;
    }
}
