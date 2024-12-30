package _011_MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cct
 * https://leetcode.cn/problems/count-submatrices-with-all-ones/
 */
public class NumSubmat {


    public int numSubmat(int[][] mat) {
        int submatrices = 0;
        int m = mat.length, n = mat[0].length;
        //heights记录(i,j)节点往上连续1个数
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
                int height = Integer.MAX_VALUE;

                //统计以(i,j)节点为右下角的矩形个数
                for (int k = j; k >= 0 && height > 0; k--) {
                    height = Math.min(height, heights[k]);
                    submatrices += height;
                }
            }
        }
        return submatrices;
    }


    //单调栈优化  niu ben
    public int numSubmat1(int[][] mat) {
        int submatrices = 0;
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            int currSubmatrices = 0;
            Deque<int[]> stack = new ArrayDeque<int[]>();
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
                int width = 1;
                int height = heights[j];
                //栈内元素高度单调递增
                while (!stack.isEmpty() && stack.peek()[1] >= height) {
                    int[] prev = stack.pop();
                    currSubmatrices -= prev[0] * (prev[1] - height);
                    width += prev[0];
                }
                currSubmatrices += height;
                submatrices += currSubmatrices;
                stack.push(new int[]{width, height});
            }
        }
        return submatrices;
    }




    public static void main(String[] args) {
        NumSubmat t = new NumSubmat();
        t.numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}});
    }
}
