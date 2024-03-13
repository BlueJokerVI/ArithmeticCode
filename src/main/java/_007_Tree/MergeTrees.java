package _007_Tree;

import java.util.Arrays;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/merge-two-binary-trees/
 */
public class MergeTrees {


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return null;
        }

        if(root1==null){
            return root2;
        }else if(root2==null){
            return root1;
        }else{
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
            return root1;
        }
    }



    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees1(root1.left, root2.left);
        root1.right = mergeTrees1(root1.right, root2.right);
        return root1;

    }
}
