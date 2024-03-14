package _007_Tree;

import _006_StackAndQueue.IsValid;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    //先序遍历处理法
    boolean dfs(TreeNode node, long minV, long maxV) {
        if (node == null) {
            return true;
        }

        boolean l = true;
        boolean r = true;

        if(node.left!=null){
            if(node.left.val<=minV || node.left.val>=maxV || node.left.val>=node.val){
                l = false;
            }
        }

        if(node.right!=null){
            if(node.right.val<=minV || node.right.val>=maxV || node.right.val<=node.val){
                r = false;
            }
        }

        if(r&&l){
            return dfs(node.left,minV,node.val)&& dfs(node.right,node.val,maxV);
        }else {
            return false;
        }

    }

    private Long maxV = Long.MIN_VALUE;

    /**
     * 二叉搜索树性质，对其中序遍历是严格递增的序列
     * @param node
     * @return
     */
    boolean inorder_dfs(TreeNode node){
        if(node==null){
            return true;
        }

        boolean l =  inorder_dfs(node.left);
        if(node.val > maxV) {
            maxV = (long)node.val;
        }else {
            return false;
        }
        boolean r = inorder_dfs(node.right);
        return l&&r;
    }


}
