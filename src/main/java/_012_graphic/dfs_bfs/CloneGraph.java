package _012_graphic.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/clone-graph/?envType=study-plan-v2&envId=top-interview-150
 */
public class CloneGraph {

    private boolean[] vis = new boolean[101];
    private Map<Integer,Node> mp = new HashMap<>();
    private Map<Integer,List<Integer>> mpNeighbors = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        dfs(node);
        mp.forEach((k,v)->{
            List<Integer> list = mpNeighbors.get(k);
            for (int integer : list) {
                Node neighbor = mp.get(integer);
                v.neighbors.add(neighbor);
            }
        });
        return mp.get(node.val);
    }

    void dfs(Node n){
        Node node = new Node(n.val);
        mp.put(n.val,node);
        vis[n.val] = true;
        List<Node> neighbors = n.neighbors;
        List<Integer> tmp = new ArrayList<>();
        for (Node neighbor : neighbors) {
            tmp.add(neighbor.val);
            if(vis[neighbor.val]){
                continue;
            }
            dfs(neighbor);
        }
        mpNeighbors.put(n.val,tmp);
    }


    public Node cloneGraph1(Node node) {
        //记录旧node与新node的映射关系
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node,Node> lookup) {
        if (node == null) {
            return null;
        }
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n,lookup));
        }
        return clone;
    }


}
