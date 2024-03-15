package _007_Tree;

import org.apache.poi.ss.formula.functions.T;

import java.time.temporal.Temporal;

public class DeleteNode {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode node = new TreeNode(1);
        dfs(root,node,true,key);

        return node.left;
    }


    void dfs(TreeNode node, TreeNode father, boolean LR, int key) {
        if (node == null) {
            return;
        }

        if (node.val > key) {
            dfs(node.left, node, true, key);
        } else if (node.val < key)
            dfs(node.right, node, false, key);
        else {
            //无右子树
            if(node.right==null){
                if(LR){
                    father.left = node.left;
                }else {
                    father.right = node.left;
                }
            }else if(node.right.left==null&&node.right.right==null){
                //右子树就一个节点

                TreeNode cNode = node.right;
                cNode.left = node.left;
                cNode.right = null;

                if(LR){
                    father.left = cNode;
                }else {
                    father.right = cNode;
                }
            }else {
                //右子树有多个节点
                TreeNode cNode = findRightMin(node);
                cNode.left = node.left;
                cNode.right = node.right;

                if(LR){
                    father.left = cNode;
                }else {
                    father.right = cNode;
                }
            }
        }
    }


    TreeNode findRightMin(TreeNode root) {
        TreeNode tmp = root.right;

        //找最左下角节点的父节点
        while (tmp.left.left != null) {
            tmp = tmp.left;
        }

        TreeNode v = tmp.left;
        tmp.left = null;
        return v;
    }
}
