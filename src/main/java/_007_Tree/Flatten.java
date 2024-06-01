package _007_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150
 */
public class Flatten {

    private final List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        dfs(root);
        for (int i = 0; i < list.size()-1; i++) {
            TreeNode cur = list.get(i);
            TreeNode next = list.get(i+1);
            cur.left=null;
            cur.right = next;
        }

        TreeNode treeNode = list.get(list.size() - 1);
        treeNode.left=null;
        treeNode.right=null;
    }


    private void dfs(TreeNode node){
        if(node==null){
            return;
        }
        list.add(node);
        dfs(node.left);
        dfs(node.right);
    }

    public void flatten1(TreeNode root) {
        while (root!=null){
            if(root.left==null){
                root = root.right;
            }else {
                //找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right!=null){
                    pre = pre.right;
                }

                //将右子树挂在左子最右节点之下
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            //处理下个节点
            root = root.right;
        }
    }

    private TreeNode later = null;

    public void flatten2(TreeNode root) {
        if(root==null){
            return;
        }

        flatten2(root.right);
        flatten2(root.left);
        root.left=null;
        root.right = later;
    }


}
