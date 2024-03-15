package _007_Tree;
//https://leetcode.cn/problems/insert-into-a-binary-search-tree/

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }

        if(root.val>val){
            root.left =  insertIntoBST(root.left,val);
        }else {
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }
}
