package _012_graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlantic {

    /**
     * mem[i][j][0]表示[i][j]是否能到大西洋
     * mem[i][j][1]表示[i][j]是否能到太平洋
     */
    boolean[][][] mem = new boolean[201][201][2];
    int[][] vis = new int[201][201];
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for(int i=0;i<heights.length;i++){
            dfsToAlt(i,heights[0].length-1,heights);
            dfsToPac(i,0,heights);
        }

        for(int j=0;j<heights[0].length;j++){
            dfsToAlt(heights.length-1,j,heights);
            dfsToPac(0,j,heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[i].length;j++){
                if(mem[i][j][0] && mem[i][j][1]){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    ans.add(integers);
                }
            }
        }

        return ans;
    }

    void dfsToAlt(int i,int j,int[][] heights){
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length || vis[i][j]==1){
            return;
        }
        vis[i][j] = 1;
        mem[i][j][0] = true;
        if(i-1>=0 && heights[i][j]<= heights[i-1][j]){
            dfsToAlt(i-1,j,heights);
        }
        if(j-1>=0 && heights[i][j]<= heights[i][j-1]){
            dfsToAlt(i,j-1,heights);
        }
        if(i+1<heights.length && heights[i][j]<= heights[i+1][j]){
            dfsToAlt(i+1,j,heights);
        }
        if(j+1<heights[0].length && heights[i][j]<= heights[i][j+1]){
            dfsToAlt(i,j+1,heights);
        }
    }


    void dfsToPac(int i,int j,int[][] heights){
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length || vis[i][j]==2){
            return;
        }
        vis[i][j] = 2;
        mem[i][j][1] = true;
        if(i+1< heights.length && heights[i][j]<= heights[i+1][j]){
            dfsToPac(i+1,j,heights);
        }
        if(j+1< heights[0].length && heights[i][j]<= heights[i][j+1]){
            dfsToPac(i,j+1,heights);
        }
        if(j-1>=0 && heights[i][j]<= heights[i][j-1]){
            dfsToPac(i,j-1,heights);
        }
        if(i-1>=0 && heights[i][j]<= heights[i-1][j]){
            dfsToPac(i-1,j,heights);
        }
    }
}
