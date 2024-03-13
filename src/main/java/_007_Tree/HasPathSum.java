package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/path-sum/
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return dfs(root,targetSum,0);
    }

    boolean dfs(TreeNode node,int target,int pre){
        if(node==null){
            return false;
        }
        int cur = pre + node.val;
        if(node.left==null&&node.right==null&&target==cur){
            return true;
        }


        return dfs(node.left,target,cur) || dfs(node.right,target,cur);


    }
}
