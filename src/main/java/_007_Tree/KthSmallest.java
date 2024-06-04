package _007_Tree;

import org.junit.Test;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-interview-150
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return v;
    }

    private boolean f = false;
    private int cnt = 0;
    private int v;
    void dfs(TreeNode treeNode,int k){
        if(f){
            return;
        }
        if(treeNode==null){
            return;
        }
        dfs(treeNode.left,k);
        cnt++;
        if(cnt==k){
            f = true;
            v = treeNode.val;
        }
        dfs(treeNode.right,k);
    }




    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return f;
    }

    private long pre = Integer.MIN_VALUE;
//    private boolean f = true;
    void dfs(TreeNode root){
        if(root==null || !f){
            return;
        }
        dfs(root.left);
        System.out.println(root.val - pre);
        if(Long.compare(root.val,pre)==-1 || root.val == pre) {
            f = false;
        }
        pre = root.val;
        dfs(root.right);
    }


    @Test
    public void test(){
        System.out.println(Integer.MIN_VALUE);
    }

}
