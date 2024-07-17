package _012_graphic.matrix;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class SearchMatrix {
    int m;
    int n;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;

        return find(matrix, 0, m - 1, 0, n - 1, target);
    }

    //每次排除1/4的面积
    private boolean find(int[][] matrix, int t, int b, int l, int r, int target) {

        while (t <= b && l <= r) {
            int midh = t + (b - t) / 2;
            int midw = l + (r - l) / 2;

            if (matrix[midh][midw] > target) {
                if(findH(matrix,midw,t,midh-1,target) || findW(matrix,midh,l,midw-1,target)
                        ||find(matrix, t, midh - 1, midw + 1, r, target)
                        ||find(matrix, midh + 1, b, l, midw - 1, target)){
                    return true;
                }
                b = midh - 1;
                r = midw - 1;
            } else if (matrix[midh][midw] < target) {
                return findW(matrix,midh,midw+1,r,target)
                        ||findH(matrix,midw,midh+1,b,target)
                        ||find(matrix, t, midh - 1, midw + 1, r, target)
                        || find(matrix, midh + 1, b, midw + 1, r, target)
                        || find(matrix, midh + 1, b, l, midw - 1, target);
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean findH(int[][] matrix,int col,int t,int b,int target){
        if(col<0 || col>=n || t <0 ||b>=m){
            return false;
        }
        while (t<=b){
            int m = t+(b-t)/2;
            if(matrix[m][col] > target){
                b = m-1;
            }else if (matrix[m][col] < target){
                t = m+1;
            }else {
                return true;
            }
        }
        return false;
    }
    
    
    private boolean findW(int[][] matrix,int row,int l,int r,int target){
        if(row<0 || row>=m || l <0 ||r>=n){
            return false;
        }
        //1 2  2
        //0 1   mid = 0
        while (l<=r){
            int m = l+(r-l)/2;
            if(matrix[row][m] > target){
                r = m-1;
            }else if (matrix[row][m] < target){
                l = m+1;
            }else {
                return true;
            }
        }
        return false;
    }




    public boolean searchMatrix1(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        //从右上角开始找
        for(int i=0;i<m;i++){
            if(matrix[i][n-1]>=target){
                for(int j=n-1;j>=0;j--){
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
            }
        }
       return false;
    }



    @Test
    public void test() {
        if (searchMatrix(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},5)) {
            System.out.println(1);
        }
    }
}
