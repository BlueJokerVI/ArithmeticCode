package _007_Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftValue {

    private int ans;
    private int maxH=-1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    void dfs(TreeNode node,int h){
        if(node==null){
            return;
        }

        if(node.left==null && node.right==null){
            if(h>maxH){
                maxH = h;
                ans = node.val;
            }
        }

        dfs(node.left,h+1);
        dfs(node.right,h+1);

    }
}
