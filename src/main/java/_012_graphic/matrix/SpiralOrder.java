package _012_graphic.matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-interview-150
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int dirF = 0;

        List<Integer> ans = new ArrayList<>();
        int x = 0,y=0;

        while (canGo(x,y,vis,matrix)){
            ans.add(matrix[x][y]);
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                if(canGo(x + dir[(dirF+i)%4][0],y + dir[(dirF+i)%4][1],vis,matrix)){
                    x = x + dir[(dirF+i)%4][0];
                    y = y + dir[(dirF+i)%4][1];
                    dirF = dirF + i;
                    break;
                }
            }
        }
        return ans;
    }
    boolean canGo(int x, int y, boolean[][] vis, int[][] matrix){
        if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && !vis[x][y]){
            return true;
        }
        return false;
    }

    class Solution {

        //双指针写法
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = n - 1, top = 0, bottom = m - 1;
            while (left <= right && top <= bottom) {
                // 从左到右
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                // 从上到下
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
                // 从右到左
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                }
                bottom--;
                // 从下到上
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                }
                left++;
            }
            return ans;
        }
    }


    @Test
    public void test(){
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
