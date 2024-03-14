package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/search-in-a-binary-search-tree/
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        if(root.val > val){
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }

    }
}
