package _007_Tree;

import java.util.Map;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class DiameterOfBinaryTree {

    //相当于求节点某节点左右子树高度之和的最大值

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = height(node.left);
        int t = height(node.right);
        if(l+t > max){
            max = l+t;
        }
        return Math.max(l,t)+1;
    }
}
