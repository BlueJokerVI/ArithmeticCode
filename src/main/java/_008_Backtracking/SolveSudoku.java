package _008_Backtracking;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sudoku-solver/
 */
public class SolveSudoku {


    List<Pair<Integer,Integer>> list = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i,j);
                    list.add(pair);
                }
            }
        }
        dfs(0,board);

    }


    boolean dfs(int index,char[][] board){

        if(index==list.size()){
            return true;
        }

        Pair<Integer, Integer> pair = list.get(index);
        int i = pair.getKey();
        int j = pair.getValue();
        for(char v='1';v<='9';v++){
            if(isValid(i, j, board,v)){
                board[i][j] = v;
                if(dfs(index+1,board)){
                    return true;
                }
                board[i][j] = '.';
            }
        }

        return false;
    }


    boolean isValid(int i, int j, char[][] mp, char v) {
        for (int k = 0; k < 9; k++) {
            if (mp[i][k] == v) {
                return false;
            }
        }

        for (int k = 0; k < 9; k++) {
            if (mp[k][j] == v) {
                return false;
            }
        }


        // 0 1 2   3 4 5   6 7 8
        // 0  3  6

        // 9宫格里是否重复
        int startRow = (i / 3) * 3;
        int startCol = (j / 3) * 3;
        for (int k = startRow; k < startRow + 3; k++){
            for (int m = startCol; m < startCol + 3; m++){
                if (mp[k][m] == v){
                    return false;
                }
            }
        }

        return true;
    }


    @Test
    public void test() {
//        char[] a = new char[4];
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]=='a');
//        }

        for (char a = '1'; a <= '9'; a++) {
            System.out.println(a);
        }
    }

}
