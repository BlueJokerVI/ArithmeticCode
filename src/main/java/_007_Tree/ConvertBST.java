package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class ConvertBST {

    int pre = -1;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }


    void dfs(TreeNode node){

        if(node==null){
            return;
        }

        dfs(node.right);
        if(pre==-1){
            pre = 0;
        }else {
            node.val += pre;
            pre = node.val;
        }
        dfs(node.left);
    }
}
