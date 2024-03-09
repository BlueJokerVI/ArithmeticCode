package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/subtree-of-another-tree/
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSameTree(root,subRoot)){
            return true;
        }else {
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null&&q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        if(p.val!=(q.val)){
            return false;
        }

        return isSameTree(p.left,q.left) &&  isSameTree(p.right,q.right);
    }


}
