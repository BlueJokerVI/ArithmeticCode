package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
public class SumOfLeftLeaves {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        return sum;
    }


    void dfs(TreeNode node){
        if(node==null){
            return;
        }

        if(node.left!=null){
            if(node.left.left==null&&node.left.right==null){
                sum+=node.left.val;
                return;
            }
        }

        dfs(node.left);
        dfs(node.right);

    }
}
