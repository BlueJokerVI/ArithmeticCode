package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }

        int cV = root.val;

        if(cV<low){
            return  trimBST(root.right,low,high);
        }

        if(cV>high){
            return  trimBST(root.left,low,high);
        }

        if(root!=null) {
            root.left = trimBST(root.left,low,high);
        }

        if(root!=null) {
            root.right = trimBST(root.right,low,high);
        }

        return root;
    }
}
