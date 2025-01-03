package _012_graphic.matrix;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-interview-150
 */
public class SetZeroes {


    // m+n常数空间
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if(row[i]){
                Arrays.fill(matrix[i],0);
            }
        }

        for(int j=0;j<col.length;j++){
            if(col[j]){
                for(int i=0;i< matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /**
     * 常量的常数空间，将第一行第一例标记某行某列是否有0
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            boolean row0_flag = false;
            boolean col0_flag = false;
            // 第一行是否有零
            for (int j = 0; j < col; j++) {
                if (matrix[0][j] == 0) {
                    row0_flag = true;
                    break;
                }
            }
            // 第一列是否有零
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    col0_flag = true;
                    break;
                }
            }
            // 把第一行第一列作为标志位
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            // 置0
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row0_flag) {
                for (int j = 0; j < col; j++) {
                    matrix[0][j] = 0;
                }
            }
            if (col0_flag) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
