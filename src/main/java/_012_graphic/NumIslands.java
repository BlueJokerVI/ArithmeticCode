package _012_graphic;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/number-of-islands/
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int[][] vis = new int[grid.length][grid[0].length];
        int ans = 0;
        Deque<Pair<Integer,Integer>> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='0' || vis[i][j]==1){
                    continue;
                }

                ans++;
                q.push(new Pair<>(i,j));
                vis[i][j] = 1;

                while (!q.isEmpty()){
                    Pair<Integer, Integer> pop = q.pop();
                    
                    int x = pop.getKey();
                    int y = pop.getValue();
                    for (int k = 0; k < dir.length; k++) {
                        int tmpX = x + dir[k][0];
                        int tmpY = y + dir[k][1];
                        if(tmpX>=0&&tmpX< grid.length && tmpY>=0 && tmpY< grid[i].length && grid[tmpX][tmpY]=='1' && vis[tmpX][tmpY]==0){
                            vis[tmpX][tmpY] = 1;
                            q.push(new Pair<>(tmpX,tmpY));
                        }
                    }
                }

            }
        }

        return ans;
    }

    @Test
    public void test(){
        numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        });
    }

}
