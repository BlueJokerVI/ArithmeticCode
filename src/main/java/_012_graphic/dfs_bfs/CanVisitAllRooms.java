package _012_graphic.dfs_bfs;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/keys-and-rooms/
 */
public class CanVisitAllRooms {

    boolean[] vis = new boolean[1001];
    int cnt;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(0,rooms);
        return cnt == rooms.size();
    }

    void dfs(int index,List<List<Integer>> rooms){
        if(!vis[index]){
            vis[index] = true;
            cnt++;
            List<Integer> toList = rooms.get(index);
            for (int integer : toList) {
                if(!vis[integer]){
                    dfs(integer,rooms);
                }
            }
        }
    }
}
