package _007_Tree;

import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/balanced-binary-tree/
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {

        if(root==null){
            return true;
        }

        int l = getH(root.left);
        int r = getH(root.right);
        if(Math.abs(l-r)>1){
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int getH(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(getH(node.left),getH(node.right))+1;
    }

    boolean f = true;

    int ans(TreeNode node){
        if(node==null){
            return 0;
        }
        int l,r;
        l = ans(node.left);
        r = ans(node.right);
        if(Math.abs(l-r)>1){
            f = false;
        }
        return Math.max(l,r);
    }



}
