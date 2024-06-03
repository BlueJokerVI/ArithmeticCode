package _007_Tree;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
 */
public class SumNumbers {
    private int sum;
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return sum;
    }

    private void getSum(TreeNode root ,int pre){

        int cur = pre*10 + root.val;
        if(root.left==null && root.right==null){
            sum += cur;
            return;
        }
        if(root.left!=null){
            getSum(root.left,cur);
        }
        if(root.right!=null){
            getSum(root.right,cur);
        }
    }
}
