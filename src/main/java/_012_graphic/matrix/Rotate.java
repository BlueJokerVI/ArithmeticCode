package _012_graphic.matrix;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150
 */
public class Rotate {


    //借助辅助矩阵
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] ans = new int[n][n];

        //i行  ---->   n-1-i列    i,j    j,n-1-i
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                matrix[i][j] = ans[i][j];
            }
        }

    }


    //原地算法
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        //i,j  --->  j,n-1-i


        for(int i=0;i<n/2;i++){
            for(int j=0;j<(n+1)/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }

    }

}
