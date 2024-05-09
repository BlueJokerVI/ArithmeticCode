package _012_graphic.union_find_set;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-if-path-exists-in-graph/
 */
public class ValidPath {

    int[] father = new int[200001];

    private int find(int u){
        // 路径压缩
        if (u == father[u]) {
            return u;
        }else {
            return father[u] = find(father[u]);
        }
    }

    private void join(int u,int v){
        int fu = find(u);
        int fv = find(v);
        if(fu==fv){
            return;
        }
        father[fu] = fv;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        //初始化
        for(int i=0;i<n;i++){
            father[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0],edges[i][1]);
        }

        int u = find(source);
        int v = find(destination);

        return u==v;

    }
}
