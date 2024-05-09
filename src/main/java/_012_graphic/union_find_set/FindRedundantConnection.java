package _012_graphic.union_find_set;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/redundant-connection/
 */
public class FindRedundantConnection {
    int[] father = new int[1001];

    private int find(int u){
        if(u==father[u]){
            return u;
        }else {
            return father[u]= find(father[u]);
        }
    }

    private void join(int u,int v){
        int i = find(u);
        int i1 = find(v);
        if(i==i1){
            return;
        }
        father[i] = i1;
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> tmpAns = new ArrayList<>();
        for(int i=1;i<=edges.length;i++){
            father[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = find(edges[i][0]);
            int v = find(edges[i][1]);
            if(u==v){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(edges[i][0]);
                tmp.add(edges[i][1]);
                tmpAns.add(tmp);
            }else {
                father[u] =v;
            }
        }

        List<Integer> integers = tmpAns.get(tmpAns.size() - 1);
        return new int[]{integers.get(0),integers.get(1)};
    }
}
