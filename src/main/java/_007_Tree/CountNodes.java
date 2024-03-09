package _007_Tree;

import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/count-complete-tree-nodes/
 */
public class CountNodes {

    private int cnt=0;
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        dfs(root);
        return cnt;
    }



    void dfs(TreeNode node){
        cnt++;
        if(node.left!=null) {
            dfs(node.left);
        }
        if(node.right!=null){
            dfs(node.right);
        }
    }

    int ans(TreeNode node){

        if(node==null){
            return 0;
        }

        int l=0,r=0;
        TreeNode tmp = node;
        while (tmp.left!=null){
            tmp = tmp.left;
            l++;
        }
        tmp = node;
        while (tmp.right!=null){
            tmp = tmp.right;
            r++;
        }
        if(r==l){
            return (int) Math.pow(2,r) -1;
        }else {
            return ans(node.left)+ans(node.right)+1;
        }
    }



}


