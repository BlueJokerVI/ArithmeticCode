package _007_Tree;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepth {


    public int maxDepth(Node root) {

        if(root==null){
            return 0;
        }
        return dfs(root,1);
    }

    int dfs(Node node,int h){
        if(node==null){
            return h;
        }

        int max = h;
        if(node.children!=null){
            for (Node child : node.children) {
                int v = dfs(child, h + 1);
                if(v>max){
                    max = v;
                }
            }
        }
        return max;
    }
}
